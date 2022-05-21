package edu.school21.cinema.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@WebServlet(name = "ImageServlet", value = "/images")
public class ImageServlet extends BaseServlet {

    @Value("${app.imagestore.path}")
    String imageStorePath;

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
