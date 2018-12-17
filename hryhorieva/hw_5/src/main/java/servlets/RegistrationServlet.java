package servlets;

import dao.impl.DBConnection;
import dao.impl.JDBCUserDao;
import entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.ArrayList;


public class RegistrationServlet extends HttpServlet {
    @Autowired
    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        this.userService = ac.getBean(UserService.class);
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
            User newUser = userService.userRegistration(new User(new_login, new_password));
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
