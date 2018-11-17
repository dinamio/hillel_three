package servlets;

import service.DocManager;
import model.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DocumentsList  extends HttpServlet {
    DocManager manager;

    @Override
    public void init() throws ServletException {
        super.init();
        manager = new DocManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("docs", manager.getAllDocs());
        getServletContext().getRequestDispatcher("/views/documentsList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession();
        //Document newDoc = new Document(request.getParameter("name"), request.getParameter("date"));
       // manager.addDoc(newDoc);
    }

   /* protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("doc");
        Document docFromList = new Document(name);
        DocManager manager = new DocManager();
        ArrayList<Document> docs = manager.getDocs();
        manager.removeDoc(docFromList);

        RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/views/documentsList.jsp");
        rs.forward(request, response);
    }*/
}
