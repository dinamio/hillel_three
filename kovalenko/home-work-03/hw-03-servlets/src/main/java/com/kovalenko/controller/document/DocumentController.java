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

        String pathInfo = req.getPathInfo();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            String pathParameter = pathParts[1];
            if (pathParameter != null) {
                Document document = documentService.find(Long.parseLong(pathParameter));
                req.setAttribute("document", document);

                dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document.jsp");
                dispatcher.forward(req, resp);
            }
        }

        String action = req.getParameter("action");

        if (action == null) {
            List<Document> documents = documentService.find();
            req.setAttribute("documents", documents);

            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/documents.jsp");
            dispatcher.forward(req, resp);
        } else {
            switch (action) {
                case "create":
                    dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document-form.jsp");
                    dispatcher.forward(req, resp);
                    break;
            }
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
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
