package edu.school21.cinema.filters;

import edu.school21.cinema.exceptions.RequestProcessingException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.utils.AppUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/profile/*",  "/images/*"})
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (AppUtils.getLoginedUser(req.getSession()) != null)
            chain.doFilter(req, res);
        else
            throw new RequestProcessingException("Unauthorized", 403);
    }
}
