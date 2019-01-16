package com.hillel.test.service;

import com.hillel.test.dao.ServerDao;
import com.hillel.test.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by eugen on 12/8/17.
 */
@Service
public class ServersService {

    @Autowired
    ServerDao serverDao;

    public List<Server> findAllServers() {
        return (List<Server>) serverDao.findAll();
    }
}
