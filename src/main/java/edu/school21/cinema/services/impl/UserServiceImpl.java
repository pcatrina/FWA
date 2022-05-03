package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public void registerNewUser(HttpServletRequest request) {
        User user =  getUser(request);

        System.out.println(user.toString());
    }

    @Override
    public boolean checkUser(HttpServletRequest req) {
        return userRepository.isUserExist(getUser(req));
    }

    private User getUser(HttpServletRequest request){
        return User.builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .phone(request.getParameter("phone"))
                .password(request.getParameter("password"))
                .build();
    }
}
