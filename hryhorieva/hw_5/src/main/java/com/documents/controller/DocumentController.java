package com.documents.controller;

import com.documents.entity.Document;
import com.documents.entity.User;
import com.documents.services.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

@Controller
public class DocumentController {
    @Autowired
    DocumentServiceImpl documentServiceImpl;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getRegistrationPage(Model model) {
        model.addAttribute("document", new Document());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addNewDocument(@ModelAttribute("document") Document document,
                                 HttpSession session) {
        User user = (User)session.getAttribute("user");
        document.setUser(user);
        documentServiceImpl.newDocument(document);
        return "redirect:/documents";
    }

    @RequestMapping(value = "documents", method = RequestMethod.GET)
    public ModelAndView showAllDocuments(Model model) {
        ModelAndView mav = new ModelAndView("show_docs");
        mav.addObject("documents", documentServiceImpl.allDocuments());
        return mav;
    }

    @RequestMapping(value = "documents", method = RequestMethod.PUT)
    public String changeDocument(HttpSession session,
                                 @RequestParam("id") Integer id,
                                 @RequestParam("name")  String name){
        User user = (User)session.getAttribute("user");
        Document document = new Document(id, name, user);
        documentServiceImpl.updateById(document);
        return "documents";
    }

    @RequestMapping(value = "documents", method = RequestMethod.DELETE)
    public String deleteDocument(@RequestParam("id") Integer id){
        documentServiceImpl.deleteById(id);
        return "documents";
    }

}
