package controller;

import entity.User;
import org.springframework.context.ApplicationContext;
import service.CigaretteService;
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
    private CigaretteService cigaretteService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext context = AppContext.getSpringContext();
        userService = context.getBean(UserService.class);
        cigaretteService = context.getBean(CigaretteService.class);
    }

    /**
     * Logout
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("login", null);
        resp.sendRedirect("/");
    }

    /**
     * Login
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(userName);

        User user = userService.getByName(userName);

        if (user != null) {
            if (password.equals(user.getPassword())) {
                user.setCigarette(cigaretteService.getById(user.getCigaretteId()));
                req.getSession().setAttribute("login", user);
                resp.getWriter().write("ok");
            } else {
                resp.getWriter().write("Incorrect password");
            }
        } else {
            resp.getWriter().write("user " + userName + " no exist");
        }
    }
}
