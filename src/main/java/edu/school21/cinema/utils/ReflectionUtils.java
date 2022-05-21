package edu.school21.cinema.utils;

import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {
    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
    }
}
