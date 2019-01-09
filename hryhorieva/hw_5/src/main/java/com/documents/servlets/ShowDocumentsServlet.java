package com.documents.servlets;

import com.documents.entity.Document;
import com.documents.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.documents.services.impl.DocumentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class ShowDocumentsServlet extends HttpServlet {
    @Autowired
    DocumentServiceImpl documentServiceImpl;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Document> documents = documentServiceImpl.allDocuments();
        req.setAttribute("documents", documents);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/show_docs.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        documentServiceImpl.deleteById(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        Document document = new Document(id, name, user);
        documentServiceImpl.updateById(document);
    }

    @Override
    public void destroy() {
        System.out.print("destroy show");
        super.destroy();
    }

}
