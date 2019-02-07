package servlets;

import dao.DAOFactory;
import dao.DocumentDAO;
import dao.UserDAO;
import model.Document;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DocumentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class UpdateDocServlet extends HttpServlet {
    @Autowired
    DocumentService documentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            documentDAO = DAOFactory.getInstance().getDocDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "updateDoc", method = RequestMethod.POST)
    public String updateDoc(@RequestParam("upDocName") String name, @RequestParam("upDocDate") String date,
                            @RequestParam("upDocId") int id, HttpSession session) throws Exception {
        int userId = (int) session.getAttribute("currentUserId");
        Document upDoc = new Document(id, name, date, userId);
        documentDAO = DAOFactory.getInstance().getDocDAO();
        documentDAO.update(upDoc);
        return "redirect:/documentsList";
    }

    @RequestMapping(value = "updateDoc", method = RequestMethod.GET)
    public String updateDocPage (@RequestParam("upDocName") String name, @RequestParam("upDocDate") String date,
                            @RequestParam("upDocId") int id, HttpSession session) throws Exception {
        return "updateDoc";
    }

   /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("upDocName");
        String date = request.getParameter("upDocDate");
        int id = Integer.parseInt(request.getParameter("upDocId"));
        int userId = (int) request.getSession().getAttribute("currentUserId");

        Document upDoc = new Document(id, name, date, userId);
        try {
            documentDAO = DAOFactory.getInstance().getDocDAO();
            documentDAO.update(upDoc);
            request.setAttribute("docs", documentDAO.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/documentsList");
    }*/

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO user;
        String author = "";
        try {
            user = DAOFactory.getInstance().getUserDAO();
            author = user.getById(Integer.parseInt(request.getParameter("docUser")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("upDocId", Integer.parseInt(request.getParameter("docId")));
        request.setAttribute("upDocName", request.getParameter("docName"));
        request.setAttribute("upDocDate", request.getParameter("docDate"));
        request.setAttribute("upDocAuthor", author);
        getServletContext().getRequestDispatcher("/views/updateDoc.jsp").forward(request, response);
    }*/
}
