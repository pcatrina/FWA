package edu.school21.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.school21.cinema.mappers.FormFieldsMapper;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/signIn")
public class SignInServlet extends BaseServlet {

    private UserService userService;
    private FormFieldsMapper formFieldsMapper;
    private static final String AUTH_PAGE = "WEB-INF/html/authorization.html";
    private static final String REG_PAGE = "WEB-INF/html/registration.html";
    private static final String USER_PAGE = "WEB-INF/html/user_page.html";

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
        this.userService = springContext.getBean(UserServiceImpl.class);
        this.formFieldsMapper = springContext.getBean(FormFieldsMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req,resp,AUTH_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = formFieldsMapper.convertValue(req.getParameterMap(), User.class);
        if(!userService.getUser(user.getPhone(),user.getPassword()).isPresent()){
            forwardToPage(req,resp,REG_PAGE);
        }
        else {
            forwardToPage(req, resp, USER_PAGE);
        }
    }
}
