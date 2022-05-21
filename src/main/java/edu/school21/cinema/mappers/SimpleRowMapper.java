package edu.school21.cinema.mappers;

import edu.school21.cinema.models.Entity;
import edu.school21.cinema.utils.EntityUtils;
import edu.school21.cinema.utils.ReflectionUtils;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SimpleRowMapper<T extends Entity> implements RowMapper<T> {

    private Class<T> entityClass;
    private static  Map<Class<?>, Method> methodMapping;


    private SimpleRowMapper(Class<T> clazz) {
        entityClass = clazz;
        setMethodMapping();
    }
    private SimpleRowMapper(){}

    public static <T extends Entity> SimpleRowMapper<T> of(Class<T> clazz){
        return new SimpleRowMapper<>(clazz);
    }

    @SneakyThrows
    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        T entity;
        try {
            entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalStateException("Entity object must have public default constructor to create an instance");
        }
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field.set(entity, methodMapping.get(field.getType()).invoke(resultSet, EntityUtils.getColumnName(field)));
        }
        return entity;
    }


    @SneakyThrows
    private void setMethodMapping(){
        if (methodMapping != null)
            return;
        methodMapping = new HashMap<>();
        methodMapping.put(Long.class, ResultSet.class.getDeclaredMethod("getLong", String.class));
        methodMapping.put(String.class, ResultSet.class.getDeclaredMethod("getString", String.class));
        // TODO добавить больше дефолтных типов и возможность добавлять кастомные мапперы
    }


}
