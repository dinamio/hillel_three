package controller;

import dao.impldao.ImplApartmentsDAO;
import entity.Apartments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Appartments", urlPatterns = {"/appartments/*"})
public class AppartmentsController extends HttpServlet {

    ImplApartmentsDAO apartmentDAO;

    @Override
    public void init() throws ServletException {
        apartmentDAO = new ImplApartmentsDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartments apartment = new Apartments();

        apartment.setAddress(req.getParameter("address"));
        apartment.setTypeEstate(req.getParameter("typeEstate"));
        apartment.setFloor(Integer.valueOf(req.getParameter("floor")));
        apartment.setCountOfRoom(Integer.valueOf(req.getParameter("countOfRoom")));
        apartment.setSize(Integer.valueOf(req.getParameter("size")));
        apartment.setAdditionalDescription(req.getParameter("additionalDescription"));
        apartmentDAO.addApartment(apartment);
        req.setAttribute("listApp",apartmentDAO.getAllAppartments());
        getServletContext().getRequestDispatcher("/allApartments.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listApp",apartmentDAO.getAllAppartments());
        getServletContext().getRequestDispatcher("/allApartments.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartments apartment = new Apartments();
        int id = Integer.valueOf(req.getParameter("idApart"));
        apartment.setEstateId(id);
        apartment.setAddress(req.getParameter("address"));
        apartment.setTypeEstate(req.getParameter("typeEstate"));
        apartment.setFloor(Integer.valueOf(req.getParameter("floor")));
        apartment.setCountOfRoom(Integer.valueOf(req.getParameter("countOfRoom")));
        apartment.setSize(Integer.valueOf(req.getParameter("size")));
        apartment.setAdditionalDescription(req.getParameter("additionalDescription"));
        apartmentDAO.updateApartment(apartment);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("idApart"));
        apartmentDAO.deleteApartment(id);
    }
}
