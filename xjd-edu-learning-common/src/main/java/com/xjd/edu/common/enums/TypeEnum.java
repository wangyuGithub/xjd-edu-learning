package com.xjd.edu.common.enums;

@Deprecated
public interface TypeEnum<T> {

    T getType();

    String getMsg();

    TypeEnum<T> parse(T type);
}
