package com.hillel.boot.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 11/21/18.
 */
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before filtering 1");
        String firstName = servletRequest.getParameter("first_name");
        if ("Max".equals(firstName)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
        System.out.println("After filtering 1");
    }

    public void destroy() {

    }
}
