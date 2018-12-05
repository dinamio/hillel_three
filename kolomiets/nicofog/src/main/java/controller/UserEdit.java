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
 * Edit(PUT) and get(GET) user by his id ( host/user-edit/15 )
 */
@WebServlet(urlPatterns = "/user-edit/*")
public class UserEdit extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getPathInfo().substring(1);

        User user = userService.getById(Long.valueOf(userId));

        req.getSession().setAttribute("user-edit", user);

        resp.sendRedirect("/edit-user.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId(Long.valueOf(req.getParameter("id")));
        user.setName(req.getParameter("userName"));
        user.setRole(req.getParameter("role"));
        user.setCigarettePrice(Integer.valueOf(req.getParameter("price")));

        user = userService.update(user);
        if (user != null) {
            req.getSession().setAttribute("login", user);
        }
        if ("admin".equals(user.getRole())) {
            resp.getWriter().write("admin");
        }
        req.getSession().setAttribute("crud-result", userService.getResultMessage());
        resp.getWriter().write("user");
    }
}
