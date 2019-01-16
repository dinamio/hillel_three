package com.hillel.test.dao;

import com.hillel.test.model.Server;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by eugen on 11/21/17.
 */
public interface ServerDao extends CrudRepository<Server, Integer> {

    Server findByName(String name);
}
