package com.kovalenko.controller.document;

import com.kovalenko.entity.document.Document;
import com.kovalenko.entity.user.User;
import com.kovalenko.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public ModelAndView find() {
        ModelAndView view = new ModelAndView("documents/documents");
        view.addObject("documents", documentService.find());
        return view;
    }

    @RequestMapping(value = "/documents/{documentID}", method = RequestMethod.GET)
    public ModelAndView find(@PathVariable(value = "documentID") long documentID) {
        ModelAndView view = new ModelAndView("documents/document");
        view.addObject("document", documentService.find(documentID));
        return view;
    }

    @RequestMapping(value = "/documents/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView view = new ModelAndView("documents/document-create");
        view.addObject("document", new Document());
        return view;
    }

    @RequestMapping(value = "/documents", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("document") Document document,
                               BindingResult bindingResult,
                               HttpSession session) {

        ModelAndView view = new ModelAndView();

        if (bindingResult.hasErrors()) {
            view.addObject("document", document);
            view.addAllObjects(bindingResult.getModel());
            view.setViewName("documents/document-create");
            return view;
        }

        User author = (User) session.getAttribute("user");
        if (author != null){
            document.setAuthor(author);
        }
        documentService.save(document);
        view.setViewName("redirect:/documents");
        return view;
    }

    @RequestMapping(value = "/documents/{documentID}/update", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(value = "documentID") long documentID) {
        ModelAndView view = new ModelAndView("documents/document-update");
        view.addObject("document", documentService.find(documentID));
        return view;
    }

    @RequestMapping(value = "/documents/{documentID}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable(value = "documentID") long documentID,
                               @Valid @ModelAttribute("document") Document document,
                               BindingResult bindingResult) {

        ModelAndView view = new ModelAndView();

        if (bindingResult.hasErrors()) {
            view.addObject("document", document);
            view.addAllObjects(bindingResult.getModel());
            view.setViewName("documents/document-update");
            return view;
        }

        documentService.update(documentID, document);
        view.setViewName("redirect:/documents/" + documentID);
        return view;
    }

    @RequestMapping(value = "/documents/{documentID}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable(value = "documentID") long documentID) {
        documentService.delete(documentID);
        return new ModelAndView("redirect:/documents");
    }
}