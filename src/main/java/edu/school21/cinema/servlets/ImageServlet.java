package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.RequestProcessingException;
import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImagesService;
import edu.school21.cinema.utils.AppUtils;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ImageServlet", value = "/images/*")
@MultipartConfig
public class ImageServlet extends BaseServlet {

    ImagesService imagesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        initSpringContext(config);
        this.imagesService = springContext.getBean(ImagesService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String arg = getArgument(req.getPathInfo());
        Image image = imagesService.getImage(Long.valueOf(arg));
        FileInputStream fis = imagesService.getImageFile(arg);
        resp.addHeader("Content-Disposition", String.format("filename=\"%s\"", image.getFilename()));
        resp.setContentLength(image.getSize().intValue());
        fis.transferTo(resp.getOutputStream());
        resp.getOutputStream().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = AppUtils.getLoginedUser(req.getSession());
        imagesService.saveImage(user, req.getPart("uploadedImage"));
        resp.sendRedirect(req.getContextPath() + "/profile");
    }

    private String getArgument(String pathInfo) {
        String[] parts = pathInfo.split("/");
        if (parts.length != 2)
            throw new RequestProcessingException("Not Found", 404);
        return parts[1];
    }
}
