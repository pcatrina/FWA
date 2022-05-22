package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.Log;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.services.LogService;
import edu.school21.cinema.utils.AppUtils;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends BaseServlet {
    private static final String PROFILE_PAGE = "WEB-INF/jsp/profile.jsp";

    ImagesService imagesService;
    LogService logService;



    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
        imagesService = springContext.getBean(ImagesService.class);
        logService = springContext.getBean(LogService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = AppUtils.getLoginedUser(req.getSession());
        List<Image> userImages = imagesService.getUserImages(user);
        List<Log> userLogs = logService.getLogsListByUserId(user.getId());
        req.setAttribute("userLogs", userLogs);
        req.setAttribute("loginedUser", user);
        req.setAttribute("userImages", userImages);
        forwardToPage(req, resp, PROFILE_PAGE);
    }

}
