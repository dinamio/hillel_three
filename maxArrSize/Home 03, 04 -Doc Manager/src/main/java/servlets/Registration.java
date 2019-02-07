package servlets;

import dao.DAOFactory;
import dao.UserDAO;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class Registration extends HttpServlet {
    @Autowired
    UserService userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        //userService = new UserService();
        try {
            userDAO = DAOFactory.getInstance().getUserDAO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if((request.getParameter("newUserName") != null) && (request.getParameter("newUserPass") != null)){
            String name = request.getParameter("newUserName");
            String pass = md5Apache(request.getParameter("newUserPass"));
            User newUser = new User(name, pass);
            //userService.addUser(newUser);
            try {
                userDAO.add(newUser);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("newUser", newUser);
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
        } else {
            String message = "Fill all fields!!";
            RequestDispatcher rs = request.getRequestDispatcher("/views/registrationForm.jsp");
            request.setAttribute("errorMsg", message);
            rs.include(request, response);
        }
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher("/views/registrationForm.jsp");
        request.setAttribute("errorMsg", "");
        rs.include(request, response);
    }

    public static String md5Apache(String pass) {
        String md5Hex = DigestUtils.md5Hex(pass);
        return md5Hex;
    }
}