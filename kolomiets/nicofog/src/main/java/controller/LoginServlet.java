package controller;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mihail on 11/9/18.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService = new UserService();
        String userName = req.getParameter("username");

        User user = userService.getByName(userName);

        if (user == null) {
            resp.sendRedirect("/");
        } else {
            req.getSession().setAttribute("login", user);
            resp.sendRedirect("/user-page.jsp");
        }
    }
}
