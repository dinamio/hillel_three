package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCDocumentDao;
import entity.Document;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import services.DocumentService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


public class AddDocumentServlet extends HttpServlet {
    @Autowired
    DocumentService documentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        this.documentService = ac.getBean(DocumentService.class);
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
        documentService.newDocument(new Document(name,user));
        System.out.print(name);
        resp.sendRedirect(req.getContextPath() + "/documents");
    }

    @Override
    public void destroy() {
        System.out.print("destroy");
        super.destroy();
    }

}
