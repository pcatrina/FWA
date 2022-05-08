package edu.school21.cinema.filters;

import edu.school21.cinema.models.User;
import edu.school21.cinema.utils.AppUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/profile", "/images"})
public class SecurityFilter implements Filter {
    private static final String FORBIDDEN_PAGE = "WEB-INF/jsp/errors/forbidden.jsp";
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (AppUtils.getLoginedUser(req.getSession()) != null) {
            chain.doFilter(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            res.setContentType(MimeTypeUtils.TEXT_HTML_VALUE);
//            IOUtils.copy(new FileReader("src/main/webapp/WEB-INF/html/Forbidden.html"), res.getWriter());
            req.getRequestDispatcher(FORBIDDEN_PAGE).forward(req, res);
        }
    }
}
