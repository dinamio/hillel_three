package controller;

import dao.UserDAO;
import dao.impldao.ImplUserDAO;
import entity.User;
import service.Cipher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static service.Cipher.encodeString;

public class UserController extends HttpServlet {
    UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new ImplUserDAO();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("Name", null);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = encodeString(req.getParameter("password"));

        if (userDAO.checkUser(name, password) == null) {
            resp.sendRedirect("registration.jsp");
        } else {
            req.getSession().setAttribute("Name", name);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setName(req.getParameter("name"));
        String password = req.getParameter("password");
        String encodeString = encodeString(password);
        user.setPassword(encodeString);
        user.setEmail(req.getParameter("email"));

        if (userDAO.getUserByName(user.getName()) == null) {
            userDAO.addUser(user);
            req.getSession().setAttribute("Name", user.getName());
            resp.sendRedirect("allApartments.jsp");
        } else {
            req.setAttribute("UserExist", true);
            resp.sendRedirect("registration.jsp");
        }
    }
}