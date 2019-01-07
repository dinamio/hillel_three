package com.documents.controller;

import com.documents.entity.User;
import com.documents.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("newUser") User user,
                                  HttpSession session,
                                  HttpServletRequest req) {
        if(!(user.getLogin().equals("")) && !(user.getPassword().equals(""))) {
            User newUser = userServiceImpl.userRegistration(user);
            if (newUser != null) {
                session.setAttribute("user", newUser);
                req.setAttribute("result_message", "you registered successfully");
            } else {
                req.setAttribute("result_message", "this login is already used");
            }
        }else{
            req.setAttribute("result_message", "login and password must be filled");
        }
        return "registration_result";
    }

    @RequestMapping(value = "authorization", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("user") User user,
                         HttpSession session,
                         HttpServletRequest req) {
        if(!(user.getLogin().equals("")) && !(user.getPassword().equals(""))){
            User currentUser = userServiceImpl.userAuthorization(user);
            if(user != null){
                session.setAttribute("user", currentUser);
                req.setAttribute("result_message", "you sign in successfully");
            }else{
                req.setAttribute("result_message", "wrong login or password");
            }
        }else{
            req.setAttribute("result_message", "login and password must be filled");
        }
        return "registration_result";
    }

    @RequestMapping(value = "registration", method = RequestMethod.DELETE)
    public String signOut(HttpSession session) {
        session.removeAttribute("user");
        return "registration";
    }
}
