package controller;

import dao.ApartmentsDAO;
import dao.impldao.ImplApartmentsDAO;
import entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MVCApartments {

    @Autowired
    ApartmentsDAO apartmentDAO;

    @RequestMapping(value = "/Appartments", method = RequestMethod.GET)
    public ModelAndView getAppartments() {
        ModelAndView mav = new ModelAndView("allApartments");

        mav.addObject("listApp", apartmentDAO.getAllAppartments());
        mav.addObject("apartment", new Apartment());
        return mav;
    }
    @RequestMapping(value = "/Appartments/add", method = RequestMethod.GET)
    public ModelAndView addAppartment() {
        ModelAndView mav = new ModelAndView("addAppartment");
        mav.addObject(new Apartment());
        return mav;
    }

    @RequestMapping(value = "/Appartments/edit", method = RequestMethod.POST)
    public String editApartment(@ModelAttribute("Apartment") Apartment apartment) {
        apartmentDAO.updateApartment(apartment);
        return "redirect:/Appartments";
    }

    @RequestMapping(value = "/Appartments", method = RequestMethod.POST)
    public String addApartment(@ModelAttribute("Apartment") Apartment apartment, HttpSession session) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        apartment.setDate(formatForDateNow.format(dateNow));
        apartment.setUser(session.getAttribute("Name").toString());
        apartmentDAO.addApartment(apartment);
        return "redirect:/Appartments";
    }

    @RequestMapping(value = "/Appartments/{idAdpartment}", method = RequestMethod.DELETE)
    public ModelAndView  deleteApartment(@PathVariable(value = "idAdpartment") int idAdpartment) {
        apartmentDAO.deleteApartment(idAdpartment);
        return new ModelAndView("redirect:/Appartments");
    }

}