package edu.school21.cinema.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.school21.cinema.mappers.PasswordDeserializer;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;
    String firstName;
    String lastName;
    String phone;
    @JsonDeserialize(using = PasswordDeserializer.class)
    String password;
}
