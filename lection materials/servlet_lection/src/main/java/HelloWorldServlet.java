import service.PetService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 11/7/18.
 */
public class HelloWorldServlet extends HttpServlet {

    PetService petService;

    @Override
    public void init() throws ServletException {
        super.init();
        petService = new PetService();
        System.out.println("INIT!!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pets", petService.getAllPets());
        req.setAttribute("name", "Игорь");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        petService.addOneYear(Integer.valueOf(id));

    }
}
