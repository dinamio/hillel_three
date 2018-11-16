package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.System.out;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();

        String userName = request.getParameter("name");
        String userPass = request.getParameter("pass");

        if(loginValidation(userName, userPass)) {
            RequestDispatcher rs = request.getRequestDispatcher("/views/documentsList.jsp");
            rs.forward(request, response);
        } else {
            out.println("Name or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }

    }


    public boolean loginValidation (String username,String pass) {
        boolean validLogin = false;
        if ((username != null) && (username.equals("admin"))) {
            if ((pass != null) && (pass.equals("admin"))) {
                validLogin = true;
            }
        }
        return validLogin;
    }
}
