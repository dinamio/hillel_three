package app.servlets;

import app.entities.Document;

import app.service.DocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    private DocumentService documentService;


    @Override
    public void init(){

        documentService = new DocumentService();

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        Document doc = new Document(name);
        documentService.RemoveDocument(doc);

        req.setAttribute("documentName", name);

        resp.sendRedirect("views/delete.jsp");

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
