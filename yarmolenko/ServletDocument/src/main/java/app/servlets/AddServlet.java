package app.servlets;

import app.dao.DocumentConnection;
import app.entities.Document;
import app.service.DocumentService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    DocumentConnection connection;
    private DocumentService documentService;



    @Override
    public void init(){

        documentService = new DocumentService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("userLogin");
        String name = req.getParameter("name");


        Document doc = new Document(name);
        documentService.addDocument(doc);

        req.setAttribute("documentName", name);
        req.setAttribute("login", login);

        resp.sendRedirect("views/add.jsp");

        doGet(req, resp);


    }
}



/*String date = req.getParameter("date");


        SimpleDateFormat dateFormat = new SimpleDateFormat("documentService-MMM-yyyy");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
            date = dateFormat.format(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
