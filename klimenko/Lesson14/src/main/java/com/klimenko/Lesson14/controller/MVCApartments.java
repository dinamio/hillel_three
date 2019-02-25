package com.klimenko.Lesson14.controller;

import com.klimenko.Lesson14.dao.ApartmentsDaoSD;
import com.klimenko.Lesson14.dao.UserDaoSD;
import com.klimenko.Lesson14.entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@MultipartConfig
public class MVCApartments {

    @Autowired
    ApartmentsDaoSD apartmentDAO;
    @Autowired
    UserDaoSD userDAO;

    @RequestMapping(value = "/Appartments", method = RequestMethod.GET)
    public ModelAndView getAppartments() {
        ModelAndView mav = new ModelAndView("allApartments");

        mav.addObject("listApp", apartmentDAO.findAll());
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
        apartmentDAO.save(apartment);
        return "redirect:/Appartments";
    }

    @RequestMapping(value = "/Appartments", method = RequestMethod.POST)
    public ModelAndView addApartment(@Valid @ModelAttribute("apartment") Apartment apartment, BindingResult bindingResult,
                                     HttpSession session) {
        ModelAndView view = new ModelAndView();
        if (bindingResult.hasErrors()) {
            view.addObject("apartment", apartment);
            view.addAllObjects(bindingResult.getModel());
            view.setViewName("addAppartment");
            return view;
        }

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        apartment.setDate(formatForDateNow.format(dateNow));
        apartment.setUser(userDAO.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName()));

        apartment.setTitle(apartment.getUploadfile().getOriginalFilename());
        apartment.setType(apartment.getUploadfile().getContentType());
        try {
            apartment.setPicture(apartment.getUploadfile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        apartmentDAO.save(apartment);
        view.setViewName("redirect:/documents");
        return view;
    }

    @RequestMapping(value = "/Appartments/{idAdpartment}", method = RequestMethod.DELETE)
    public ModelAndView deleteApartment(@PathVariable(value = "idAdpartment") int idAdpartment) {
        apartmentDAO.deleteByEstateId(idAdpartment);
        return new ModelAndView("redirect:/Appartments");
    }

}