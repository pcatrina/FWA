package edu.school21.cinema.utils;

import edu.school21.cinema.models.User;
import jakarta.servlet.http.HttpSession;

public class AppUtils {
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }


    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }
}
