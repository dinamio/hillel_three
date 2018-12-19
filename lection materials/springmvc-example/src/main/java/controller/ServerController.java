package controller;

import dao.ServerDao;
import model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by eugen on 11/21/17.
 */
@Controller
public class ServerController {

    @Autowired
    private ServerDao serverDao;

    @RequestMapping(value = "server", method = RequestMethod.GET)
    public ModelAndView getServers() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("servers", serverDao.findAll());
        return mav;
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("servers",serverDao.findAll());*/
    }


    @RequestMapping(value = "server/add", method = RequestMethod.GET)
    public String addServerPage(Model model) {
        model.addAttribute("server", new Server("My server"));
        return "addServer";
    }

    @RequestMapping(value = "server/add", method = RequestMethod.POST)
    public String addServer(@ModelAttribute("server") Server server, Model model) {
        serverDao.save(server);
        return "redirect:/server";
    }

    /*@RequestMapping(value = "server/add", method = RequestMethod.POST)
    public String addServer(@RequestBody("login") String login, @RequestBody("password") String password) {
        serverDao.save(server);
        return "server";
    }*/



}
