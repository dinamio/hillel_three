package com.kovalenko.controller.document;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "DocumentController", urlPatterns = {"/documents"})
public class DocumentController extends HttpServlet {
}
