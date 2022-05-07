package edu.school21.cinema.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected
    ApplicationContext springContext;

    protected void initSpringContext(ServletConfig config){
        ServletContext servletContext = config.getServletContext();
        springContext = (ApplicationContext) servletContext.getAttribute("springContext");
    }

    protected void forwardToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

}
