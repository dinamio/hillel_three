package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Redirect to '/' if user don't enter
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        if (session.getAttribute("login") == null) {
            if ("/edit-user.jsp".equals(url)
                    || "/admin-page.jsp".equals(url)
                    || "/user-page.jsp".equals(url)) {
                ((HttpServletResponse) servletResponse).sendRedirect("/");
            }
        } else if ("/".equals(url)) {
            ((HttpServletResponse) servletResponse).sendRedirect("user-page.jsp");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
