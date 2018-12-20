package com.documents.servlets;

import com.documents.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.documents.services.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RegistrationServlet extends HttpServlet {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_login = req.getParameter("user_login");
        String new_password = req.getParameter("user_password");
        HttpSession session = req.getSession();
        System.out.print(new_login + new_password);

        if((new_login != null) && (new_password != null)){
            User newUser = userServiceImpl.userRegistration(new User(new_login, new_password));
            if(newUser != null){
                session.setAttribute("user", newUser);
                req.setAttribute("result_message", "you registered successfully");
            }else{
                req.setAttribute("result_message", "this login is already used");
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration_result.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
    }

    @Override
    public void destroy() {
        System.out.print("destroy registration");
        super.destroy();
    }
}