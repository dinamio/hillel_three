package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCDocumentDao;
import entity.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class AddDocument extends HttpServlet {
    Connection connection = DBConnection.getInstance().getConnection();
    JDBCDocumentDao documentDao = new JDBCDocumentDao(connection);
    @Override
    public void init() throws ServletException {
        System.out.print("init");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("document_name");
        documentDao.insert(new Document(name));
        List <Document> documents = documentDao.selectAll();
        req.setAttribute("documents", documents);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/show_docs.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        System.out.print("destroy");
        super.destroy();
    }

}
