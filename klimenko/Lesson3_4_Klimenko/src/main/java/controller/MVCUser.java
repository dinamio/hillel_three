package controller;


import dao.ApartmentsDAO;
import dao.UserDAO;
import entity.Apartment;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import java.io.UnsupportedEncodingException;

import static service.Cipher.encodeString;

@Controller
public class MVCUser {
    @Autowired
    @Qualifier("ImplUserDAOHibernate")
    UserDAO userDAO;

    @ModelAttribute("user")
    public User populateUser() {
        User user = new User();
        return user;
    }

    @RequestMapping(value = "/UserController", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("user")User user, BindingResult bindingResult,
                                HttpSession httpSession, Model model){


        ModelAndView view = new ModelAndView();

        if (bindingResult.hasErrors()) {
            view.addObject("user", user);
            view.addAllObjects(bindingResult.getModel());
            view.setViewName("registration");
            return view;
        }
        try {
            user.setPassword(encodeString(user.getPassword()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (userDAO.getUserByName(user.getName()) == null) {
            userDAO.addUser(user);
            httpSession.setAttribute("Name", user.getName());
            view.setViewName("redirect:/Appartments");
        } else {
            view.addObject(new User());
            view.setViewName("registration");
            model.addAttribute("UserExist", true);
        }
        return view;
    }

    @RequestMapping(value = "/UserController/Registration", method = RequestMethod.GET)
    public ModelAndView registerUser() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject(new User());
        return mav;
    }

    @RequestMapping(value = "/UserController/login", method = RequestMethod.GET)
    public ModelAndView loginUser() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject(new User());
        return mav;
    }

    @RequestMapping(value = "/UserController/login", method = RequestMethod.POST)
    public ModelAndView checkUser(@ModelAttribute("user") User user,
                                  HttpSession httpSession) {

        ModelAndView view = new ModelAndView();
        try {
            if (userDAO.checkUser(user.getName(), encodeString(user.getPassword())) == null) {
                view.setViewName("redirect:/registration");
            } else {
                httpSession.setAttribute("Name", user.getName());

                view.setViewName("redirect:/Appartments");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return view;
    }
    @RequestMapping(value = "/UserController", method = RequestMethod.DELETE)
    public ModelAndView resetUser(HttpSession httpSession){
        httpSession.setAttribute("Name", null);
        return new ModelAndView("redirect:/login");
    }

}
