package edu.school21.cinema.servlets;

import edu.school21.cinema.mappers.FormFieldsMapper;
import edu.school21.cinema.models.Log;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.LogService;
import edu.school21.cinema.services.UserService;
import edu.school21.cinema.services.impl.UserServiceImpl;
import edu.school21.cinema.utils.AppUtils;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SignInServlet", value = "/signIn")
public class SignInServlet extends BaseServlet {

    private UserService userService;
    private FormFieldsMapper formFieldsMapper;
    private LogService logService;
    private static final String AUTH_PAGE = "WEB-INF/jsp/authorization.jsp";
    private static final String USER_PAGE = "WEB-INF/jsp/profile_page.html";
    private static final String UNDESIRED_ADDRES= "0:0:0:0:0:0:0:1";

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
        this.userService = springContext.getBean(UserServiceImpl.class);
        this.formFieldsMapper = springContext.getBean(FormFieldsMapper.class);
        this.logService = springContext.getBean(LogService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardToPage(req, resp, AUTH_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = formFieldsMapper.convertValue(req.getParameterMap(), User.class);
            Optional<User> authenticatedUser = userService.authenticate(user);
            if (authenticatedUser.isPresent()) {
                logService.createNewLogForUser(authenticatedUser.get(), getIp(req));
                AppUtils.storeLoginedUser(req.getSession(), authenticatedUser.get());
                resp.sendRedirect(req.getContextPath() + "/profile");
            } else {
                req.setAttribute("error", "Wrong phone number or password");
                forwardToPage(req, resp, AUTH_PAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Something went wrong ...");
            forwardToPage(req, resp, AUTH_PAGE);
        }

    }

    private String getIp(HttpServletRequest request){
        String addr = request.getRemoteAddr();
        if (addr.equals(UNDESIRED_ADDRES))
            return "127.0.0.1";
        return addr;
    }
}
