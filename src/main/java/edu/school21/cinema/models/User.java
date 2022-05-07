package edu.school21.cinema.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;
    String firstName;
    String lastName;
    String phone;
    String password;
}
