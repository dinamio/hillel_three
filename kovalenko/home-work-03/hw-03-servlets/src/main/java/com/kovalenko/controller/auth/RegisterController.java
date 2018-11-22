package com.kovalenko.controller.auth;

import com.kovalenko.entity.user.User;
import com.kovalenko.service.user.UserService;
import com.kovalenko.service.user.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/auth/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userService.getUserByCredentials(login, password) == null) {
            User newUser = new User();
            newUser.setName(name);
            newUser.setLogin(login);
            newUser.setPassword(password);
            userService.register(newUser);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/register");
        }
    }
}
