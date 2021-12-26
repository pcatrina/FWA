package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public void createUser(HttpServletRequest request) {
        User user = new User(
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("phone"),
                request.getParameter("password")
        );

        System.out.println(user.toString());
    }
}
