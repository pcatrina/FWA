package edu.school21.cinema.services.impl;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public void saveNewUser(User user) {
        userRepository.saveUser(user);

        System.out.println(user.toString());
    }

    @Override
    public boolean checkUser(HttpServletRequest req) {
        return false;
    }

    @Override
    public Optional<User> getUser(String phone, String passwordDigest) {
        return userRepository.getUser(phone, passwordDigest);
    }

//    private User getUser(HttpServletRequest request){
//        return User.builder()
//                .firstName(request.getParameter("firstName"))
//                .lastName(request.getParameter("lastName"))
//                .phone(request.getParameter("phone"))
//                .password(request.getParameter("password"))
//                .build();
//    }
}
