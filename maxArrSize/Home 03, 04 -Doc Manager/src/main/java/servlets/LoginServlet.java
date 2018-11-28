package servlets;

import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String invalidCredentials = "Invalid credentials";
        String fillAllFields = "Fill all fields!!";

        String name = request.getParameter("name");
        String pass = md5Apache(request.getParameter("pass"));

        if ((name != "") && (pass != "")) {
            User user = new User(name, pass);
            if ((request.getSession().getAttribute("newUser") != null)) {
                User newUser = (User) request.getSession().getAttribute("newUser");
                if (newUser.getUserName().equals(user.getUserName()) && newUser.getUserPass().equals(user.getUserPass())) {
                    request.getSession().setAttribute("currentUserName", user.getUserName());
                    sendRequest(request, response, "/views/documentsList.jsp", "");
                } else {
                    sendRequest(request, response, "index.jsp", invalidCredentials);
                }
            } else if (userService.checkRegisteredUsers(user)) {
                request.getSession().setAttribute("currentUserName", user.getUserName());
                sendRequest(request, response, "/views/documentsList.jsp", "");
            } else {
                sendRequest(request, response, "index.jsp", invalidCredentials);
            }
        } else {
            sendRequest(request, response, "index.jsp", fillAllFields);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void sendRequest(HttpServletRequest request, HttpServletResponse response, String page, String message)
            throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher(page);
        request.setAttribute("errorMsg", message);
        rs.include(request, response);
    }

    public static String md5Apache(String pass) {
        String md5Hex = DigestUtils.md5Hex(pass);
        return md5Hex;
    }
}