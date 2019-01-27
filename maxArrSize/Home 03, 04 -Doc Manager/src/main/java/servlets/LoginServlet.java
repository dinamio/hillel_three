package servlets;

import dao.DAOFactory;
import model.Document;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DocumentService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class LoginServlet extends HttpServlet {
    @Autowired
    UserService userDAO;

    @Autowired
    DocumentService documentDAO;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "pass", required = true) String pass, HttpSession session) throws Exception{
        String viewPage = "index";
        String errorMsg = "Invalid credentials";
        User user = new User();
        user.setName(name);
        user.setPass(md5Apache(pass));
        int userId = userDAO.getIdByNamePass(user);
        if (userId == 0) {
            session.setAttribute("errorMsg", errorMsg);
            return viewPage;
        }
        session.setAttribute("currentUser", user.getName());
        session.setAttribute("currentUserId", userId);
        sendListOfDocs(session);
        sendListOfUsers(session);
        viewPage = "/documentsList";
        return viewPage;
    }

   /* @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        ModelAndView view = new ModelAndView("login");
        view.addObject("user", new User());
        return view;
    }*/




    /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String invalidCredentials = "Invalid credentials";

        String name = request.getParameter("name");
        String pass = md5Apache(request.getParameter("pass"));

        User user = new User(name, pass);
        int userId = 0;

        try {
            userId = userDAO.getByName(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(userId != 0) {
            request.getSession().setAttribute("currentUser", user.getUserName());
            request.getSession().setAttribute("currentUserId", userId);
            try {
                sendListOfDocs(request, response);
                sentListOfUsers(request, response);
                getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sendRequest(request, response, "index.jsp", invalidCredentials);
        }
    }*/

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void sendRequest(HttpServletRequest request, HttpServletResponse response, String page, String message)
            throws ServletException, IOException {
        RequestDispatcher rs = request.getRequestDispatcher(page);
        request.setAttribute("errorMsg", message);
        rs.forward(request, response);
    }*/

    public static String md5Apache(String pass) {
        String md5Hex = DigestUtils.md5Hex(pass);
        return md5Hex;
    }

    public void sendListOfDocs(HttpSession session)
            throws Exception {
        documentDAO = DAOFactory.getInstance().getDocDAO();
        List<Document> docs = documentDAO.getAll();
        session.setAttribute("docs", docs);
    }

    public void sendListOfUsers(HttpSession session)
            throws Exception {
        userDAO = DAOFactory.getInstance().getUserDAO();
        List<User> users = userDAO.getAll();
        session.setAttribute("users", users);
    }
}