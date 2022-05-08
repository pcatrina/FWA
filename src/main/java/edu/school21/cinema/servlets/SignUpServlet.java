package edu.school21.cinema.servlets;

import edu.school21.cinema.mappers.FormFieldsMapper;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signUp")
public class SignUpServlet extends BaseServlet {

    private UserService userService;
    private FormFieldsMapper formFieldsMapper;
    private static final String REG_PAGE = "WEB-INF/html/registration.html";
    private static final String AUTH_PAGE = "WEB-INF/html/authorization.html";

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
        this.userService = springContext.getBean(UserServiceImpl.class);
        this.formFieldsMapper = springContext.getBean(FormFieldsMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forwardToPage(request, response, REG_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = formFieldsMapper.convertValue(request.getParameterMap(), User.class);
        int result = userService.saveNewUser(user);
        if (result == 0)
            forwardToPage(request, response, REG_PAGE);
        else
            forwardToPage(request, response, AUTH_PAGE);
    }
}
