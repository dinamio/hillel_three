package app.servlets;

import app.entities.Document;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("login");
        String password = req.getParameter("password");

        if (name.equals("login") && password.equals("password")){
            req.getSession().setAttribute("Hello", "Egor");
            req.getRequestDispatcher("views/userName.html").forward(req, resp);
            //req.getSession().setAttribute(password, "Egor i Egor");
            //req.getRequestDispatcher("registration").forward(req, resp);
        }
        /*req.setAttribute("registration", name);
        doGet(req, resp);
        req.setAttribute("registration", password);
        doGet(req, resp);*/


    }
}
