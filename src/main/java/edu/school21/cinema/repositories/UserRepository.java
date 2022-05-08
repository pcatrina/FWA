package edu.school21.cinema.repositories;

import edu.school21.cinema.mappers.UserRowMapper;
import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class UserRepository extends BaseRepository {

    private UserRowMapper userRowMapper;

    public Optional<User> getUser(Long id){
        return queryForObject("SELECT * from fwa_schema.users where user_id = ?",
                new Object[]{id}, userRowMapper);
    }
    public Optional<User> getUser(String phone){
        return queryForObject("SELECT * from fwa_schema.users where PHONE = ?",
                new Object[]{phone}, userRowMapper);
    }

    public int saveUser(User user){

        return update("INSERT INTO fwa_schema.users(first_name, last_name, phone, password) VALUES (?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getPhone(), user.getPassword());
    }

    @Autowired
    public void setUserRowMapper(UserRowMapper userRowMapper) {
        this.userRowMapper = userRowMapper;
    }
}
