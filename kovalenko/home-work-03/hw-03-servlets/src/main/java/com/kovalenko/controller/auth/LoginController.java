package com.kovalenko.controller.auth;

import com.kovalenko.entity.user.User;
import com.kovalenko.service.user.UserService;
import com.kovalenko.service.user.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getUserByCredentials(login, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user-name", user.getName());
            session.setMaxInactiveInterval(30*60);
            Cookie cookie = new Cookie("user-name", user.getName());
            cookie.setMaxAge(30*60);
            resp.addCookie(cookie);
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
