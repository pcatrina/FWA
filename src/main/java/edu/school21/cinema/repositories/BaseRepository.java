package edu.school21.cinema.repositories;

import edu.school21.cinema.annotations.Column;
import edu.school21.cinema.annotations.Id;
import edu.school21.cinema.annotations.Table;
import edu.school21.cinema.mappers.SimpleRowMapper;
import edu.school21.cinema.models.Entity;
import edu.school21.cinema.utils.AppUtils;
import edu.school21.cinema.utils.EntityUtils;
import edu.school21.cinema.utils.ReflectionUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public abstract class BaseRepository<T extends Entity> {

    @Value("${app.datasource.schema}")
    private String schema;

    protected JdbcTemplate jdbcTemplate;
    private String idField;
    private String tableName;
    private RowMapper<T> rowMapper;
    protected  String getTableName(){
        if (tableName == null)
            throw new IllegalStateException("Entity class must be annotated with @Table or repository must override getTableName method");
        return tableName;
    };
    protected  String getIdField(){
        if (idField == null)
            throw new IllegalStateException("Entity class must have field annotated with @Id or repository must override getIdField method");
        return idField;
    };

    protected  RowMapper<T> getRowMapper(){
        return rowMapper;
    };

    @SuppressWarnings("unchecked")
    public BaseRepository() {
        Class<T> entityClass = (Class<T>) ReflectionUtils.getGenericParameterClass(this.getClass(),0);
        this.rowMapper = SimpleRowMapper.of(entityClass);
        setTableName(entityClass);
        setIdField(entityClass);
    }

    Optional<T> queryForObject(String sql, Object[] params, RowMapper<T> mapper) throws DataAccessException{
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, params, mapper));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public int update(String sql, Object... args) throws DataAccessException {
        try{
            return jdbcTemplate.update(sql, args);
        }
        catch (DuplicateKeyException e){
            return 0;
        }
    }

    public Optional<T> getById(Long id){
        return getByField(getIdField(), id);
    }

    public Optional<T> getByField(String field, Object value){
        return queryForObject(String.format("SELECT * FROM %s.%s WHERE %s = ?" , schema, getTableName(), field),
                new Object[]{value}, getRowMapper());
    }

    public int save(T entity){
        Map<String, Object> values = getValuesMap(entity, true); //TODO дописать вариант не игнорить id
        String insertString = getInsertString(values);
        return update(insertString, values.values().toArray());
    }

    @SneakyThrows
    private Map<String, Object> getValuesMap(T entity, boolean ignoreId){
        Map<String, Object> res = new LinkedHashMap<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) && ignoreId)
                continue;
            String name = EntityUtils.getColumnName(field);
            field.setAccessible(true);
            res.put(name, field.get(entity));
        }
        return res;
    }

    private String getInsertString(Map<String, Object> valuesMap){
        String format = "INSERT INTO %s.%s (%s) VALUES (%s)";
        String colNames = String.join(", ", valuesMap.keySet());
        String values = String.join(", ", AppUtils.getNTimes("?", valuesMap.keySet().size()));
        return String.format(format, schema, getTableName(), colNames, values);
    }

    private void setIdField(Class<T> entityClass){
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)){
                idField = EntityUtils.getColumnName(field);
                return;
            }
        }
    }

    private void setTableName(Class<T> entityClass){
        if (entityClass.isAnnotationPresent(Table.class)){
            Table table = entityClass.getAnnotation(Table.class);
            tableName = table.name();
        }
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
