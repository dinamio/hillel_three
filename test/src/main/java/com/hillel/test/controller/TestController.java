package com.hillel.test.controller;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by eugen on 11/21/17.
 */
@RestController
@RequestMapping("rest")
public class TestController {

    @Autowired
    ServerDao serverDao;

    @RequestMapping(value = "servers", method = RequestMethod.GET)
    public List<Server> getServers () {
        return (List<Server>) serverDao.findAll();
    }

    @GetMapping("test")
    public List<Server> test() {
        return (List<Server>) serverDao.findByName("name");
    }
}
