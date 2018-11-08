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

@WebServlet(name = "DocumentController", urlPatterns = {"/documents"})
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

        List<Document> documents = documentService.find();//Arrays.asList(new Document(1, "aaa", LocalDateTime.now()), new Document(2, "bbb", LocalDateTime.now()));
        req.setAttribute("documents", documents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/documents.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
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
