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
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class Registration  extends HttpServlet {
    Connection connection = DBConnection.getInstance().getConnection();
    JDBCUserDao userDao = new JDBCUserDao(connection);
    ArrayList<User> userList = (ArrayList<User>) userDao.selectAll();
    ArrayList<String> userLoginList = getLoginList();

    private ArrayList<String> getLoginList(){
        ArrayList<String> loginList = new ArrayList<>();
        this.userList.stream().forEach((a) -> loginList.add(a.getLogin()));
        return loginList;
    }
    @Override
    public void init() throws ServletException {
        System.out.print("init registration");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
        requestDispatcher.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_login = req.getParameter("new_user_login");
        String new_password = req.getParameter("new_user_password");
        String login = req.getParameter("user_login");
        String password = req.getParameter("user_password");
        HttpSession session = req.getSession();

        if((new_login != null) && (new_password != null)){
            if(userLoginList.contains(new_login)){
                req.setAttribute("result_message", "this login is already used");
            }else{
                User user = new User(new_login, DigestUtils.md5Hex(new_password));
                userDao.insert(user);
                User newUser = userDao.getByLoginAndPassword(user.getLogin(), user.getPassword());
                this.userList.add(newUser);
                this.userLoginList.add(newUser.getLogin());
                session.setAttribute("user", newUser);
                req.setAttribute("result_message", "you registered successfully");
            }
        }

        if((login != null) && (password != null)){
            User user = null;
            for(User currentUser: userList){
                if(currentUser.getLogin().equals(login)){
                    System.out.print(login);
                    if(currentUser.getPassword().equals(DigestUtils.md5Hex(password))){
                        System.out.print(password);
                        user = currentUser;
                        System.out.print(user);
                    }
                }
            }
            if(user != null){
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
