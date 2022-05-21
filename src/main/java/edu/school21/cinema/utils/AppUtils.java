package edu.school21.cinema.utils;

import edu.school21.cinema.exceptions.RequestProcessingException;
import edu.school21.cinema.models.User;
import jakarta.servlet.http.HttpSession;

import java.util.Iterator;

public class AppUtils {
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }


    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }

    public static String camelCaseToSnake(String value){
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return  value
                .replaceAll(regex, replacement)
                .toLowerCase();
    }

    public static Iterable<String> getNTimes(String str, int n){
        return () -> new Iterator<>() {
            int t = 0;
            @Override
            public boolean hasNext() {
                return t < n;
            }
            @Override
            public String next() {
                t += 1;
                return str;
            }
        };
    }
}
