import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by eugen on 11/7/18.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", req.getParameter("first_name"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/greeting.jsp");
        Cookie cookie = new Cookie("userName" , req.getParameter("first_name"));
        cookie.setMaxAge(60);
        cookie.setPath("/registration");
        resp.addCookie(cookie);
        //RequestDispatcher requestDispatcher2 = getServletContext().getRequestDispatcher("/index.jsp");
        //requestDispatcher.forward(req,resp);
        requestDispatcher.forward(req,resp);
        //requestDispatcher2.include(req,resp);
        //resp.sendRedirect("/greeting.jsp");
    }
}
