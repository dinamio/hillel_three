package com.documents.controller;

import com.documents.entity.User;
import com.documents.services.impl.UserServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(Model model) {
        return "index";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("newUser") User user,
                                  HttpServletRequest req,
                                  HttpSession session) {
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
        authenticateUserAndSetSession(user, req);
        return "redirect:/";
    }

//    @RequestMapping(value = "registration", method = RequestMethod.POST)
//    public String registerNewUser(@ModelAttribute("newUser") User user,
//                                  HttpSession session,
//                                  HttpServletRequest req) {
//        if(!(user.getLogin().equals("")) && !(user.getPassword().equals(""))) {
//            User newUser = userServiceImpl.userRegistration(user);
//            if (newUser != null) {
//                session.setAttribute("user", newUser);
//                req.setAttribute("result_message", "you registered successfully");
//            } else {
//                req.setAttribute("result_message", "this login is already used");
//            }
//        }else{
//            req.setAttribute("result_message", "login and password must be filled");
//        }
//        return "registration_result";
//    }


//    @RequestMapping(value = "registration", method = RequestMethod.DELETE)
//    public String signOut(HttpSession session) {
//        session.removeAttribute("user");
//        return "registration";
//    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getLogin();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
