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
        String pathInfo = req.getPathInfo();
        String pathParameter = null;

        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            pathParameter = pathParts[1];
        }

        if (pathParameter != null) {

            if ("update".equals(action)) {
                Document document = documentService.find(Long.parseLong(pathParameter));
                req.setAttribute("document", document);
                dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document-form.jsp");
                dispatcher.forward(req, resp);
            }

            if ("delete".equals(action)) {
                documentService.delete(Long.parseLong(pathParameter));
                resp.sendRedirect("/documents");
            } else {

                Document document = documentService.find(Long.parseLong(pathParameter));
                req.setAttribute("document", document);

                dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document.jsp");
                dispatcher.forward(req, resp);
            }
        }

        if ("create".equals(action)) {
            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document-form.jsp");
            dispatcher.forward(req, resp);
        }

        if (action == null && pathParameter == null) {

            List<Document> documents = documentService.find();
            req.setAttribute("documents", documents);

            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/documents.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String pathParameter = null;

        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            pathParameter = pathParts[1];
        }

        if (pathParameter != null) {
            String title = req.getParameter("title");
            Document document = new Document();
            document.setTitle(title);
            documentService.update(Long.parseLong(pathParameter), document);

            resp.sendRedirect("/documents");
        } else {

            resp.setContentType("application/html;charset=UTF-8");
            String title = req.getParameter("title");

            Document newDocument = new Document();
            newDocument.setTitle(title);
            newDocument = documentService.save(newDocument);

            req.setAttribute("document", newDocument);
            resp.sendRedirect("/documents");
        }
    }
}
