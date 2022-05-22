package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.RequestProcessingException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ErrorHandler")
public class ErrorHandler extends BaseServlet {

    private static final Map<Integer, String> errorPages;
    static {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(404, "WEB-INF/jsp/errors/notfound.jsp");
        aMap.put(403, "WEB-INF/jsp/errors/forbidden.jsp");
        aMap.put(500, "WEB-INF/jsp/errors/servererror.jsp");
        errorPages = Collections.unmodifiableMap(aMap);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestProcessingException e = (RequestProcessingException)
                req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        resp.setStatus(e.getErrorCode());
        forwardToPage(req,resp, errorPages.get(e.getErrorCode()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
