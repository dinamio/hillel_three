package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCDocumentDao;
import entity.Document;
import entity.User;
import services.DocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ShowDocumentsServlet extends HttpServlet {
    Connection connection = DBConnection.getInstance().getConnection();
    JDBCDocumentDao documentDao = new JDBCDocumentDao(connection);
    DocumentService documentService = new DocumentService(documentDao);

    @Override
    public void init() throws ServletException {
        System.out.print("init show");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Document> documents = documentDao.selectAll();
        req.setAttribute("documents", documents);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/show_docs.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        documentDao.deleteById(id);
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
