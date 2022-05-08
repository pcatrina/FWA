package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface UserService {

    int saveNewUser(User user);

    boolean checkUser(HttpServletRequest req);

    Optional<User> getUser(String phone);

    boolean authenticate(User user);
}
