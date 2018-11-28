package servlets;

import service.DocumentService;
import model.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DocumentsList extends HttpServlet {
    DocumentService manager;

    @Override
    public void init() throws ServletException {
        super.init();
        manager = new DocumentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Document> docs = manager.getAllDocs();
        request.setAttribute("docs", docs);
        getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        Document document = new Document(name, date);
        manager.addDoc(document);
        response.sendRedirect("/documentsList");
    }

  @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document removedDoc = null;
        long id = getPathVariable(request.getPathInfo());
        removedDoc = manager.getDocById(id);
        manager.deleteDoc(removedDoc);
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
}
