package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCDocumentDao;
import entity.Document;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import services.DocumentService;

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

public class ShowDocumentsServlet extends HttpServlet {
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
        List<Document> documents = documentService.allDocuments();
        req.setAttribute("documents", documents);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/show_docs.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        documentService.deleteById(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        Document document = new Document(id, name, user);
        documentService.updateById(document);
    }

    @Override
    public void destroy() {
        System.out.print("destroy show");
        super.destroy();
    }

}
