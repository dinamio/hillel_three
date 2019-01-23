package com.hillel.boot.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by eugen on 11/21/18.
 */
public class EncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before filtering 2");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("After filtering");
    }

    public void destroy() {

    }
}
