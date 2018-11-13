package controller;

import dao.mysql.UserRepository;
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

@WebServlet(urlPatterns = "/user-get-all")
public class UserGetAllServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService = new UserService();
        req.getSession().setAttribute("all-users", userService.getAll());


        resp.sendRedirect("/admin-page.jsp");
    }
}
