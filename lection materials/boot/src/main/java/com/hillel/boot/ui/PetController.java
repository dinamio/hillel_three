package com.hillel.boot.ui;

import com.hillel.boot.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by eugen on 1/23/19.
 */
@Controller
public class PetController {

    @Autowired
    PetService petService;

    @RequestMapping (method = RequestMethod.GET, value = "/")
    public String index(Model model) {
        model.addAttribute("pets",petService.getAllPets());
        return "index";
    }

    @RequestMapping (method = RequestMethod.POST, value = "/filter")
    public String filter(@RequestParam ("first_name") String name, Model model) {
        model.addAttribute("pets",petService.getAllPetsByName(name));
        return "index";
    }
}
