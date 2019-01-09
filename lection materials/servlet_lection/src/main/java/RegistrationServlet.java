import model.Pet;
import service.PetService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 11/7/18.
 */
public class RegistrationServlet extends HttpServlet {

    PetService petService = new PetService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("first_name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Pet pet = new Pet(null, name, age);
        petService.savePet(pet);
        req.setAttribute("pets", petService.getAllPets());
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
        /*HttpSession session = req.getSession();

        req.setAttribute("pets", petService.getAllPetsByName(req.getParameter("first_name")));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/greeting.jsp");
        Cookie cookie = new Cookie("userName" , req.getParameter("first_name"));
        cookie.setMaxAge(60);
        cookie.setPath("/registration");
        resp.addCookie(cookie);
        //RequestDispatcher requestDispatcher2 = getServletContext().getRequestDispatcher("/index.jsp");
        //requestDispatcher.forward(req,resp);
        requestDispatcher.forward(req,resp);
        //requestDispatcher2.include(req,resp);
        //resp.sendRedirect("/greeting.jsp");*/
    }
}
