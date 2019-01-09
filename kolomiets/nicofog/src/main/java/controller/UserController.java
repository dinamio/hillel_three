package controller;

import entity.Cigarette;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CigaretteService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mihail on 1/6/19.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CigaretteService cigaretteService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@ModelAttribute("login")User user){
        user = userService.login(user);
        if (user != null) {
            request.getSession().setAttribute("login", user);
            user.setCigarette(cigaretteService.getById(user.getCigaretteId()));
        }
        return userService.getResultMessage();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logout() {
        request.setAttribute("login", null);
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/user-add", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registration")User user){
        user = userService.addUser(user);

        if (user != null) {
            request.getSession().setAttribute("login", user);
            request.getSession().setAttribute("crud-result", userService.getResultMessage());
            return "ok";
        } else {
            return userService.getResultMessage();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user-delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/user-edit", method = RequestMethod.PUT)
    public String edit(@ModelAttribute("edit")User user){
        user = userService.update(user);
        if (user != null) {
            user.setCigarette(cigaretteService.getById(user.getCigaretteId()));
            request.getSession().setAttribute("login", user);
        }
        return userService.getResultMessage();
    }

    @RequestMapping(value = "/user-get-all", method = RequestMethod.GET)
    public String getAll() {
        request.getSession().setAttribute("all-users", userService.getAll());
        return "admin-page";
    }

    @ResponseBody
    @RequestMapping(value = "/smoke", method = RequestMethod.GET)
    public void smoke() {
        User user = (User)request.getSession().getAttribute("login");
        Cigarette cigarette = cigaretteService.updateOnSmoke(user);
        user.setCigarette(cigarette);
        request.getSession().setAttribute("login", user);
    }
}
