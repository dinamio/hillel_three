package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCUserDao;
import entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class AuthorizationServlet extends HttpServlet {
    Connection connection = DBConnection.getInstance().getConnection();
    JDBCUserDao userDao = new JDBCUserDao(connection);


    @Override
    public void init() throws ServletException {
        System.out.print("init authorization");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user_login");
        String password = req.getParameter("user_password");
        HttpSession session = req.getSession();

        if((login != null) && (password != null)){
            User user = null;
            User currentUser = userDao.getByLoginAndPassword(login, DigestUtils.md5Hex(password));
            if(currentUser != null){
                user = currentUser;
                System.out.print(user);
                session.setAttribute("user", user);
                req.setAttribute("result_message", "you sign in successfully");
            }else{
                req.setAttribute("result_message", "wrong login or password");
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration_result.jsp");
        requestDispatcher.forward(req,resp);
    }


    @Override
    public void destroy() {
        System.out.print("destroy authorization");
        super.destroy();
    }
}
