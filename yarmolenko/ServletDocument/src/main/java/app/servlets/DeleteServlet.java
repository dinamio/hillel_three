package app.servlets;

import app.entities.Document;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {
    @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /*PrintWriter writer = resp.getWriter();
            writer.println("Method GET from DeleteServlet");*/

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);

        String name = req.getParameter("name");
        String date = req.getParameter("date");
        Model model = Model.getInstance();
        Document doc = new Document(name, date);
        model.delete(doc);
        req.setAttribute("documentName", name);
        doDelete(req, resp);
    }

}
