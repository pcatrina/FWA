package edu.school21.cinema.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends BaseServlet {
    private static final String PROFILE_PAGE = "WEB-INF/jsp/profile.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req, resp, PROFILE_PAGE);
    }
}
