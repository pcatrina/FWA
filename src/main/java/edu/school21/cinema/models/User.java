package edu.school21.cinema.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
    Long id;
    String firstName;
    String lastName;
    String phone;
    String password;
}
