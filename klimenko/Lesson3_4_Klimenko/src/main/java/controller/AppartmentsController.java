package controller;

import dao.ApartmentsDAO;
import dao.impldao.ImplApartmentsDAO;
import dao.impldao.ImplUserDAO;
import entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
@WebServlet(name = "Appartments", urlPatterns = {"/appartments/*"})
public class AppartmentsController extends HttpServlet {

//    @Autowired
    ApartmentsDAO apartmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
          apartmentDAO = new ImplApartmentsDAO();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("action") == null) {
            getServletContext().getRequestDispatcher("/addAppartment.jsp").forward(req, resp);
        } else {
            Apartment apartment = new Apartment();

            apartment.setAddress(req.getParameter("address"));
            apartment.setTypeEstate(req.getParameter("typeEstate"));
            apartment.setFloor(Integer.valueOf(req.getParameter("floor")));
            apartment.setCountOfRoom(Integer.valueOf(req.getParameter("countOfRoom")));
            apartment.setSize(Integer.valueOf(req.getParameter("size")));
            apartment.setAdditionalDescription(req.getParameter("additionalDescription"));
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
            apartment.setDate(formatForDateNow.format(dateNow));
            apartment.setUser(req.getSession().getAttribute("Name").toString());
            apartmentDAO.addApartment(apartment);
            req.setAttribute("listApp", apartmentDAO.getAllAppartments());
            getServletContext().getRequestDispatcher("/allApartments.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listApp", apartmentDAO.getAllAppartments());
        getServletContext().getRequestDispatcher("/allApartments.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartment apartment = new Apartment();
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
