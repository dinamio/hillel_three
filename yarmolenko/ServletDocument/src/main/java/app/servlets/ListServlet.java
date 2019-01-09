package app.servlets;


import app.entities.Document;
import app.service.DocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

public class ListServlet extends HttpServlet {


    private DocumentService dd;

    @Override
    public void init() {

        dd = new DocumentService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Document> documents = dd.getAllDocuments();
        req.setAttribute("documents", documents);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);

    }

}
