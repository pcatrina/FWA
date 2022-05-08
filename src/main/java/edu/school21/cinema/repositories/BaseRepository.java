package edu.school21.cinema.repositories;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class BaseRepository {

    protected JdbcTemplate jdbcTemplate;


    <T> Optional<T> queryForObject(String sql, Object[] params, RowMapper<T> mapper) throws DataAccessException{
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

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
