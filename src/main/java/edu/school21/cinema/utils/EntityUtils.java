package edu.school21.cinema.utils;

import edu.school21.cinema.annotations.Column;

import java.lang.reflect.Field;

public class EntityUtils {
    public static String getColumnName(Field field){
        if(field.isAnnotationPresent(Column.class)) {
            Column name = field.getAnnotation(Column.class);
            return name.name();
        }
        return field.getName();
    }
}
