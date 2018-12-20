package com.kovalenko.controller.auth;

import com.kovalenko.binding.LoginForm;
import com.kovalenko.entity.user.User;
import com.kovalenko.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("auth/login");
        view.addObject("loginForm", new LoginForm());
        return view;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginForm") LoginForm loginForm,
                              HttpSession session) {

        ModelAndView view = new ModelAndView();
        User user = userService.getUserByCredentials(loginForm.getLogin(), loginForm.getPassword());

        if (user == null) {
           view.setViewName("auth/login");
           view.addObject("loginForm", loginForm);
           return view;
        }

        session.setAttribute("user", user);
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView view = new ModelAndView("auth/register");
        view.addObject("user", new User());
        return view;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") User user) {

        ModelAndView view = new ModelAndView();
        User userWithSameLogin = userService.getUserByLogin(user.getLogin());

        if (userWithSameLogin == null) {
            userService.register(user);
            view.setViewName("redirect:/login");
            return view;
        }

        view.setViewName("redirect:/register");
        return view;
    }
}
