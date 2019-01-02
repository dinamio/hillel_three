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
@WebServlet(urlPatterns = "/user-add")
public class UserAddServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = AppContext.getSpringContext().getBean(UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String priceParam = req.getParameter("price");

        int price = priceParam == null ? 0 : Integer.valueOf(priceParam);

        User user = new User();
        user.setName(name);
        user.setCigarettePrice(price);
        user.setPassword(password);

        user = userService.addUser(user);

        if (user != null) {
            req.getSession().setAttribute("login", user);
            req.getSession().setAttribute("crud-result", userService.getResultMessage());
            resp.getWriter().write("ok");
        } else {
            resp.getWriter().write(userService.getResultMessage());
        }
    }
}
