package com.xjd.edu.common.utils;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 脱敏工具类
 * <p>
 * 参考： cn.hutool.core.util.DesensitizedUtil @Since: 5.6.3
 * <p>
 * 示例：
 * <p>
 * <pre>
 *         String mobile = DesensitizedUtil.mobilePhone("15620201024");
 *         assertEquals("156****1024", mobile);
 *         String idCard = DesensitizedUtil.idCardNum("420621190004141478", 6, 4);
 *         assertEquals("420621********1478", idCard);
 *         String name = DesensitizedUtil.chineseName("唐吉诃德");
 *         assertEquals("唐***", name);
 *         String bankCard = DesensitizedUtil.bankCard("62357720000000000256");
 *         assertEquals("6235 **** **** **** 0256", bankCard);
 * </pre>
 */
public final class DesensitizedUtil {

    /**
     * 姓名脱敏
     *
     * @param fullName
     * @return
     * @see #chineseName(String)
     */
    @Deprecated
    public static String desensitizedName(String fullName) {
        if (StringUtils.isNotBlank(fullName)) {
            String nameLeft = StringUtils.left(fullName, 1);
            String nameRight = StringUtils.right(fullName, 1);
            if (StringUtils.length(fullName) > 2) {
                return StringUtils.rightPad(nameLeft, StringUtils.length(fullName) - 1, "*").concat(nameRight);
            }
            return StringUtils.rightPad(nameLeft, StringUtils.length(fullName), "*");
        }
        return fullName;
    }

    /**
     * 身份证脱敏
     *
     * @param idNumber
     * @return
     * @see #idCardNum(String, int, int)
     */
    @Deprecated
    public static String desensitizedIdNumber(String idNumber) {
        if (StringUtils.isNotBlank(idNumber)) {
            String idLeft = StringUtils.left(idNumber, 3);
            String idRight = StringUtils.right(idNumber, 3);
            return StringUtils.rightPad(idLeft, StringUtils.length(idNumber) - 3, "*").concat(idRight);
        }
        return idNumber;
    }

    /**
     * 手机号脱敏
     *
     * @param mobile
     * @return
     * @see #mobilePhone(String)
     */
    @Deprecated
    public static String desensitizedMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return mobile;
        }
        String idLeft = StringUtils.left(mobile, 3);
        String idRight = StringUtils.right(mobile, 4);
        return StringUtils.rightPad(idLeft, StringUtils.length(mobile) - 4, "*").concat(idRight);
    }

    /**
     * 【手机号码】前三位，后4位，其他隐藏，比如135****2210
     *
     * @param num 移动电话；
     * @return 脱敏后的移动电话；
     */
    public static String mobilePhone(String num) {
        if (StrUtil.isBlank(num)) {
            return StrUtil.EMPTY;
        }
        return hide(num, 3, num.length() - 4);
    }

    /**
     * 微信小程序手机打码
     * <p>
     * https://developers.weixin.qq.com/miniprogram/dev/framework/security.html#%E4%BF%A1%E6%81%AF%E6%B3%84%E9%9C%B2
     * <p>
     * eg: 156******77
     *
     * @param mobile
     * @return
     */
    public static String mobilePhoneForWechat(String mobile) {
        if (StrUtil.isBlank(mobile)) {
            return StrUtil.EMPTY;
        }
        if (mobile.length() < 10) {
            return hide(mobile, 2, mobile.length() - 2);
        }
        return hide(mobile, 3, mobile.length() - 2);
    }

    /**
     * 【身份证号】前1位 和后2位
     *
     * @param idCardNum 身份证
     * @param front     保留：前面的front位数；从1开始
     * @param end       保留：后面的end位数；从1开始
     * @return 脱敏后的身份证
     */
    public static String idCardNum(String idCardNum, int front, int end) {
        //身份证不能为空
        if (StrUtil.isBlank(idCardNum)) {
            return StrUtil.EMPTY;
        }
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) {
            return StrUtil.EMPTY;
        }
        //需要截取的不能小于0
        if (front < 0 || end < 0) {
            return StrUtil.EMPTY;
        }
        return hide(idCardNum, front, idCardNum.length() - end);
    }

    /**
     * 微信小程序身份证号打码
     * <p>
     * https://developers.weixin.qq.com/miniprogram/dev/framework/security.html#%E4%BF%A1%E6%81%AF%E6%B3%84%E9%9C%B2
     * <p>
     * eg: 3****************1
     *
     * @param idCardNum
     * @return
     */
    public static String idCardNumForWechat(String idCardNum) {
        //身份证不能为空
        if (StrUtil.isBlank(idCardNum)) {
            return StrUtil.EMPTY;
        }
        int front = 1;
        int end = 1;
        //需要截取的长度不能大于身份证号长度
        if ((front + end) > idCardNum.length()) {
            return StrUtil.EMPTY;
        }
        //需要截取的不能小于0
        if (front < 0 || end < 0) {
            return StrUtil.EMPTY;
        }
        return hide(idCardNum, front, idCardNum.length() - end);
    }

    /**
     * 【中文姓名】只显示第一个汉字，其他隐藏为2个星号，比如：李**
     *
     * @param fullName 姓名
     * @return 脱敏后的姓名
     */
    public static String chineseName(String fullName) {
        if (StrUtil.isBlank(fullName)) {
            return StrUtil.EMPTY;
        }
        return hide(fullName, 1, fullName.length());
    }

    /**
     * 微信小程序姓名打码
     * <p>
     * https://developers.weixin.qq.com/miniprogram/dev/framework/security.html#%E4%BF%A1%E6%81%AF%E6%B3%84%E9%9C%B2
     * <p>
     * eg: 王*四、欧**五、*三
     *
     * @param fullName 姓名
     * @return 脱敏后的姓名
     */
    public static String chineseNameForWechat(String fullName) {
        if (StrUtil.isBlank(fullName)) {
            return StrUtil.EMPTY;
        }
        if (fullName.length() > 2) {
            return hide(fullName, 1, fullName.length() - 1);
        }
        return hide(fullName, 0, fullName.length() - 1);
    }

    /**
     * 银行卡号脱敏
     * eg: 1101 **** **** **** 3256
     *
     * @param bankCardNo 银行卡号
     * @return 脱敏之后的银行卡号
     * @since 5.6.3
     */
    public static String bankCard(String bankCardNo) {
        if (StrUtil.isBlank(bankCardNo)) {
            return bankCardNo;
        }
        bankCardNo = StrUtil.trim(bankCardNo);
        if (bankCardNo.length() < 9) {
            return bankCardNo;
        }

        final int length = bankCardNo.length();
        final int midLength = length - 8;
        final StringBuilder buf = new StringBuilder();

        buf.append(bankCardNo, 0, 4);
        for (int i = 0; i < midLength; ++i) {
            if (i % 4 == 0) {
                buf.append(CharUtil.SPACE);
            }
            buf.append('*');
        }
        buf.append(CharUtil.SPACE).append(bankCardNo, length - 4, length);
        return buf.toString();
    }

    /**
     * 微信小程序银行卡号打码
     * <p>
     * https://developers.weixin.qq.com/miniprogram/dev/framework/security.html#%E4%BF%A1%E6%81%AF%E6%B3%84%E9%9C%B2
     * <p>
     * eg: ************1234
     *
     * @param bankCardNo 银行卡号
     * @return 脱敏之后的银行卡号
     * @since 5.6.3
     */
    public static String bankCardForWechat(String bankCardNo) {
        if (StrUtil.isBlank(bankCardNo)) {
            return bankCardNo;
        }
        return hide(bankCardNo, 0, bankCardNo.length() - 4);
    }

    /**
     * 替换指定字符串的指定区间内字符为"*"
     * 俗称：脱敏功能，后面其他功能，可以见：DesensitizedUtil(脱敏工具类)
     *
     * <pre>
     * StrUtil.hide(null,*,*)=null
     * StrUtil.hide("",0,*)=""
     * StrUtil.hide("jackduan@163.com",-1,4)   ****duan@163.com
     * StrUtil.hide("jackduan@163.com",2,3)    ja*kduan@163.com
     * StrUtil.hide("jackduan@163.com",3,2)    jackduan@163.com
     * StrUtil.hide("jackduan@163.com",16,16)  jackduan@163.com
     * StrUtil.hide("jackduan@163.com",16,17)  jackduan@163.com
     * </pre>
     *
     * @param str          字符串
     * @param startInclude 开始位置（包含）
     * @param endExclude   结束位置（不包含）
     * @return 替换后的字符串
     * @since 4.1.14
     */
    public static String hide(CharSequence str, int startInclude, int endExclude) {
        return StrUtil.replace(str, startInclude, endExclude, '*');
    }

}
