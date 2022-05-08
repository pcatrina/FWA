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

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public int saveNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveUser(user);
    }

    @Override
    public boolean checkUser(HttpServletRequest req) {
        return false;
    }

    @Override
    public Optional<User> getUser(String phone) {
        return userRepository.getUser(phone);
    }

    @Override
    public boolean authenticate(User user) {
        Optional<User> fromBase = userRepository.getUser(user.getPhone());
        return fromBase.isPresent() &&
                passwordEncoder.matches(user.getPassword(), fromBase.get().getPassword());
    }
}
