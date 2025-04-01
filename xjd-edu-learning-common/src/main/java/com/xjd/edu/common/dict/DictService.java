package com.xjd.edu.common.dict;

import com.alibaba.fastjson2.JSON;
import com.xjd.edu.common.entity.DictItem;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 字典服务，限（字典）只读服务使用（如果需要更新字典请使用原Cp层提供的原生接口）
 *
 * @author zlikun
 * @date 2021/09/14 14:36
 */
public interface DictService {

    /**
     * 查询单个字典项
     *
     * @param dictCode
     * @param itemCode
     * @return
     */
    DictItem find(@NotNull String dictCode, @NotNull String itemCode);

    /**
     * 查询指定 dict_code 下所有字典项
     *
     * @param dictCode
     * @return
     */
    List<DictItem> find(@NotNull String dictCode);

    /**
     * 查询单个字符串字典值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @return
     */
    default String findStringValue(@NotNull String dictCode, @NotNull String itemCode) {
        final DictItem item = this.find(dictCode, itemCode);
        return item != null ? item.getVal() : null;
    }

    /**
     * 查询单个浮点类型字典值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @return
     */
    default Double findDoubleValue(@NotNull String dictCode, @NotNull String itemCode) {
        final String val = this.findStringValue(dictCode, itemCode);
        return StringUtils.isNotBlank(val) ? NumberUtils.toDouble(val) : null;
    }

    /**
     * 查询单个整型字典值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @return
     */
    default Integer findIntegerValue(@NotNull String dictCode, @NotNull String itemCode) {
        final String val = this.findStringValue(dictCode, itemCode);
        return StringUtils.isNotBlank(val) ? NumberUtils.toInt(val) : null;
    }

    /**
     * 查询单个布尔字典值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @return
     */
    default Boolean findBooleanValue(@NotNull String dictCode, @NotNull String itemCode) {
        final String val = this.findStringValue(dictCode, itemCode);
        return StringUtils.isNotBlank(val) ? BooleanUtils.toBoolean(val) : null;
    }

    /**
     * 查询单个字典对象值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @param clazz
     * @param <T>
     * @return
     */
    default <T> Optional<T> findObjectValue(@NotNull String dictCode, @NotNull String itemCode, Class<T> clazz) {
        final String value = findStringValue(dictCode, itemCode);
        if (value == null) {
            return Optional.empty();
        }
        return Optional.of(JSON.parseObject(value, clazz));
    }

    /**
     * 查询单个字典泛型列表值，不存在则返回NULL
     *
     * @param dictCode
     * @param itemCode
     * @param clazz
     * @param <T>
     * @return
     */
    default <T> Optional<List<T>> findListValue(@NotNull String dictCode, @NotNull String itemCode, Class<T> clazz) {
        final String value = findStringValue(dictCode, itemCode);
        if (value == null || !value.contains("[") || !value.contains("]")) {
            return Optional.empty();
        }
        // 字符串转换为泛型列表
        return Optional.of(JSON.parseArray(value, clazz));
    }

    default <T> Optional<List<T>> findListValue(@NotNull String dictCode, @NotNull String itemCode, @NotNull Function<Object, T> mapper) {
        final String value = findStringValue(dictCode, itemCode);
        if (value == null || !value.contains("[") || !value.contains("]")) {
            return Optional.empty();
        }
        // 字符串转换为泛型列表
        return Optional.of(JSON.parseArray(value).stream().map(mapper).collect(Collectors.toList()));
    }

}
