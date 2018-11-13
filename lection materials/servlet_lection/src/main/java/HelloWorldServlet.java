import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by eugen on 11/7/18.
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("INIT!!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fruits", Arrays.asList("apple","peach","cherry"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }

}
