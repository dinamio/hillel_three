package com.kovalenko.controller.document;

import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;
import com.kovalenko.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@WebServlet(name = "DocumentController", urlPatterns = {"/documents/*"})
public class DocumentController extends HttpServlet {

    @Autowired
    private DocumentService documentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        long id = getPathVariable(req.getPathInfo());

        if (id != 0) {
            Document document = documentService.find(id);
            req.setAttribute("document", document);
            dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/document.jsp");
            dispatcher.forward(req, resp);
        }

        List<Document> documents = documentService.find();
        req.setAttribute("documents", documents);
        dispatcher = req.getRequestDispatcher("/WEB-INF/view/documents/documents.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String title = req.getParameter("title");
            Document newDocument = new Document();
            newDocument.setTitle(title);
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null){
                newDocument.setAuthor(user);
            }
            documentService.save(newDocument);
            resp.sendRedirect("/documents");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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