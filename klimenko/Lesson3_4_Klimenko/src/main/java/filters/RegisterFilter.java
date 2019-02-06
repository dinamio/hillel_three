package filters;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getServletContext();

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("Name") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    public void destroy() {

    }
}