package com.hillel.test.controller;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Locale;

/**
 * Created by eugen on 11/21/17.
 */
@Controller
@RequestMapping("server")
public class ServerController {

    @Autowired
    private ServerDao serverDao;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    //@GetMapping("get")
    public String index(Locale locale, Model model, Principal principal) {
        SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name", "Ivan");
        model.addAttribute("servers",serverDao.findAll());
        return "index";
    }

    @RequestMapping(value = "/{server_id}", method = RequestMethod.GET)
    public ModelAndView getServer(@PathVariable("server_id") Integer id) {
        ModelAndView maw = new ModelAndView();
        maw.setViewName("server");
        maw.addObject("server", serverDao.findOne(id));
        return maw;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddServerPage(Model model) {
        model.addAttribute("server", new Server());
        return "addServer";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addServer(@ModelAttribute @Valid Server server, BindingResult result) {
        if (result.hasErrors()) {
            return "addServer";
        }
        serverDao.save(server);
        return "redirect:/server/";
    }


}
