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

@Component
public class AddDocumentServlet extends HttpServlet {
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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("document_name");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        documentServiceImpl.newDocument(new Document(name,user));
        System.out.print(name);
        resp.sendRedirect(req.getContextPath() + "/documents");
    }

    @Override
    public void destroy() {
        System.out.print("destroy");
        super.destroy();
    }

}
