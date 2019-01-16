package controller.MVCController;


import dao.ApartmentsDAO;
import dao.UserDAO;
import entity.Apartment;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;

import static service.Cipher.encodeString;

@Controller
public class MVCUser {
    @Autowired
    UserDAO userDAO;


    @RequestMapping(value = "/UserController", method = RequestMethod.POST)
    public ModelAndView addUser(@PathVariable(value = "name") String name,
                                @PathVariable(value = "password") String password,
                                @PathVariable(value = "email") String email,
                                HttpSession httpSession, Model model){

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        ModelAndView view = new ModelAndView();
        try {
            user.setPassword(encodeString(password));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (userDAO.getUserByName(user.getName()) == null) {
            userDAO.addUser(user);
            httpSession.setAttribute("Name", user.getName());
            view.setViewName("redirect/allApartments");
        } else {
            view.setViewName("redirect/registration");
            model.addAttribute("UserExist", true);
        }
        return view;
    }

    @RequestMapping(value = "/UserController", method = RequestMethod.GET)
    public ModelAndView checkUser(@PathVariable(value = "name") String name,
                                  @PathVariable(value = "password") String password,
                                  HttpSession httpSession) {

        ModelAndView view = new ModelAndView();
        try {
            if (userDAO.checkUser(name, encodeString(password)) == null) {
                view.setViewName("redirect/registration");
            } else {
                httpSession.setAttribute("Name", name);
                view.setViewName("redirect/allApartments");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return view;
    }
    @RequestMapping(value = "/UserController", method = RequestMethod.DELETE)
    public ModelAndView resetUser(HttpSession httpSession){
        httpSession.setAttribute("Name", null);
        return new ModelAndView("redirect:login");


    }

}
