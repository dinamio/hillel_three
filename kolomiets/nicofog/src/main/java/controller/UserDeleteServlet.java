package controller;

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
@WebServlet(urlPatterns = "/user-delete/*")
public class UserDeleteServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteItem = req.getPathInfo().substring(1);

        try {
            long userId = Long.valueOf(deleteItem);
            userService.delete(userId);
        } catch (NumberFormatException e) {
            userService.delete(-1l);
        }

    }
}
