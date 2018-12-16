package controller.cigarettes;

import entity.Cigarette;
import entity.User;
import service.CigaretteService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mihail on 12/9/18.
 */
@WebServlet(urlPatterns = "/smoke")
public class SmokeTimeServlet extends HttpServlet {
    private CigaretteService cigaretteService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        cigaretteService = new CigaretteService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("login");
        Cigarette cigarette = cigaretteService.updateOnSmoke(user);
        userService.update(user);
        user.setCigarette(cigarette);

        session.setAttribute("login", user);

        String toWriter = cigaretteService.getMessageFromRepository();

        if (toWriter == null) {
            toWriter = "ok";
        }
        resp.getWriter().write(toWriter);
    }
}
