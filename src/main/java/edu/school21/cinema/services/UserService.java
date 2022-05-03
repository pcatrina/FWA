package edu.school21.cinema.services;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    public void registerNewUser(HttpServletRequest request);

    boolean checkUser(HttpServletRequest req);
}
