package com.kovalenko.controller.document;

import com.kovalenko.entity.document.Document;
import com.kovalenko.service.document.DocumentService;
import com.kovalenko.service.document.impl.DocumentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DocumentController", urlPatterns = {"/documents/*"})
public class DocumentController extends HttpServlet {

    private DocumentService documentService;

    @Override
    public void init() throws ServletException {
        super.init();
        documentService = new DocumentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/html;charset=UTF-8");
        RequestDispatcher dispatcher;
        String action = req.getParameter("action");
        long id = getPathVariable(req.getPathInfo());

        if (id != 0) {
            Document document = documentService.find(id);
            req.setAttribute("document", document);
            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document.jsp");
            dispatcher.forward(req, resp);
        }

        if ("create".equals(action)) {
            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document-form.jsp");
            dispatcher.forward(req, resp);
        }

        if (action == null && id == 0) {
            List<Document> documents = documentService.find();
            req.setAttribute("documents", documents);
            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/documents.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("application/html;charset=UTF-8");

            String title = req.getParameter("title");
            Document newDocument = new Document();
            newDocument.setTitle(title);
            newDocument = documentService.save(newDocument);

            req.setAttribute("document", newDocument);
            resp.sendRedirect("/documents");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/html;charset=UTF-8");

        String title = req.getParameter("title");
        Document document = new Document();
        document.setTitle(title);

        long id = getPathVariable(req.getPathInfo());
        documentService.update(id, document);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = getPathVariable(req.getPathInfo());
        documentService.delete(id);
    }

    private long getPathVariable(String pathInfo){
        long result = 0L;
        String pathVariable = null;

        if (pathInfo != null) {
            pathVariable = pathInfo.split("/")[1];
        }

        if (pathVariable != null) {
            try {
                result = Long.parseLong(pathVariable);
            } catch (NumberFormatException e) {
                return result;
            }
        }
        return result;
    }
}