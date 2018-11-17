package servlets;

import service.DocumentService;
import model.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DocumentController extends HttpServlet {
    DocumentService manager;

    @Override
    public void init() throws ServletException {
        super.init();
        manager = new DocumentService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Document> docs = manager.getAllDocs();
        request.setAttribute("docs", docs);
        getServletContext().getRequestDispatcher("/WEB-INF/views/documents.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Document document = new Document(name, LocalDate.now());
        manager.addDoc(document);
        response.sendRedirect("/documents");
    }

   /* protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("doc");
        Document docFromList = new Document(name);
        DocumentService manager = new DocumentService();
        ArrayList<Document> docs = manager.getDocs();
        manager.removeDoc(docFromList);

        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/views/documents.jsp");
        rs.forward(request, response);
    }*/
}
