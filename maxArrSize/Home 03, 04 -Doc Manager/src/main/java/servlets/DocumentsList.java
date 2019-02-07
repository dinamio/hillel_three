package servlets;

import dao.ConnectionFactoryDAO;
import dao.DAOFactory;
import dao.DocumentDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.DocumentService;
import model.Document;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("documentsList")
@Controller
public class DocumentsList extends HttpServlet {
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


    @RequestMapping(value = "documentsList", method = RequestMethod.POST)
    public String addDoc(@RequestParam("name") String name, @RequestParam("date") String date,
                             HttpSession session) throws Exception {
        int docId = documentDAO.getNumRow() + 1;
        int userId = (int) session.getAttribute("currentUserId");
        Document document = new Document(docId, name, date, userId);
        documentDAO.add(document);
        return "redirect:/documentsList";
    }

    @RequestMapping(value = "documentsList", method = RequestMethod.GET)
    public String getDocs(ModelMap model) throws Exception {
        model.addAttribute("docs", documentDAO.getAll());
        return "documentsList";
    }

    @RequestMapping(value = "documentsList", method = RequestMethod.DELETE)
    public String deleteDoc(@PathVariable("id") int id) throws Exception {
        documentDAO.delete(id);
        return "redirect:/documentsList";
    }
}

 /* @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (int) getPathVariable(request.getPathInfo());
      try {
          documentDAO = DAOFactory.getInstance().getDocDAO();
          documentDAO.delete(id);
          request.setAttribute("docs", documentDAO.getAll());
          getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }


    private long getPathVariable(String pathInfo){
        long result = 0L;
        String pathVariable = null;
        if (pathInfo != null) {
            pathVariable = pathInfo.split("/")[1];
        }
        if (pathVariable != null) {
            try {
                result = Long.parseLong(pathVariable);
            } catch (NumberFormatException e){
                return 0L;
            }
        }
        return result;
    }
}*/

    /*protected void doPost(@ModelAttribute, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        int userId = (int) request.getSession().getAttribute("currentUserId");
        int docId = 0;

        try {
            docId = documentDAO.getNumRow() + 1;
            Document document = new Document(docId, name, date, userId);
            documentDAO.add(document);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute("docs", documentDAO.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
    }*/

        /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("docs", documentDAO.getAll());
            getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }*/