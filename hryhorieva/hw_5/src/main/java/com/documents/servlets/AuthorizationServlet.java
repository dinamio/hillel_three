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
public class AuthorizationServlet extends HttpServlet {
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
        String login = req.getParameter("user_login");
        String password = req.getParameter("user_password");
        HttpSession session = req.getSession();

        if((login != null) && (password != null)){
            User user = userServiceImpl.userAuthorization(new User(login, password));
            if(user != null){
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
