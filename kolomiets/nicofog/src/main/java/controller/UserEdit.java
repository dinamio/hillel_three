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
 * Created by mihail on 11/10/18.
 */
@WebServlet(urlPatterns = "/user-edit/*")
public class UserEdit extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId =req.getPathInfo().substring(1);

        userService = new UserService();

        User user = userService.getById(Long.valueOf(userId));

        req.getSession().setAttribute("user-edit", user);

        resp.sendRedirect("/edit-user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(Long.valueOf(req.getParameter("id")));
        user.setName(req.getParameter("userName"));
        user.setRole(req.getParameter("role"));
        user.setSigaretPrice(Integer.valueOf(req.getParameter("price")));

        userService = new UserService();

        userService.update(user);
        req.getSession().setAttribute("crud-result", userService.getResultMessage());

        resp.sendRedirect("/admin-page.jsp");
    }
}
