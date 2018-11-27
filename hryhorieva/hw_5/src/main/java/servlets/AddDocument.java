package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCDocumentDao;
import entity.Document;
import entity.User;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/add.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("document_name");
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        documentDao.insert(new Document(name), user);
        System.out.print(name);
        resp.sendRedirect(req.getContextPath() + "/documents");
    }

    @Override
    public void destroy() {
        System.out.print("destroy");
        super.destroy();
    }

}
