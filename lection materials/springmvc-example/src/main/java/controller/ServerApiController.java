package controller;

import dao.ServerDao;
import model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by eugen on 1/19/19.
 */
@RestController
@RequestMapping(path = "api")
public class ServerApiController {

    final ServerDao serverDao;

    @Autowired
    public ServerApiController(ServerDao serverDao) {
        this.serverDao = serverDao;
    }

    @RequestMapping(value = "servers", method = RequestMethod.GET)
    public List<Server> getAll() {
        return serverDao.findAll();
    }

    @RequestMapping(value = "servers/{id}", method = RequestMethod.GET)
    public Server getOne(@PathVariable(value = "id") Integer id) {
        return serverDao.findById(id);
    }
}
