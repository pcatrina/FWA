package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean isUserExist(Long id){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) from fwa_schema.users where user_id = ?", new Object[]{id}, Integer.class) > 0;
    }

    public boolean isUserExist(User user){
        return jdbcTemplate.queryForObject("SELECT COUNT(*) from fwa_schema.users where first_name = ? and last_name = ? and phone = ?",
                new Object[]{user.getFirstName(), user.getLastName(), user.getPhone()}, Integer.class) > 0;
    }
}
