package edu.school21.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.school21.cinema.mappers.PasswordDeserializer;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    Long id;
    String firstName;
    String lastName;
    String phone;
    @JsonDeserialize(using = PasswordDeserializer.class)
    String password;
    @JsonIgnore
    String rawPassword;

    @JsonSetter("password")
    public void setPassword(List<String> password){
        this.password = password.get(0);
        this.rawPassword = password.get(1);
    }

    public User(Long id, String firstName, String lastName, String phone, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
    }
}
