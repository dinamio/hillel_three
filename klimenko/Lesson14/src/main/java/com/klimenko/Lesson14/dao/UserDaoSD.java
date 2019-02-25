package com.klimenko.Lesson14.dao;

import com.klimenko.Lesson14.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDaoSD extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findUserByName(String name);

    User findUserById(int id);

    User findUserByNameAndPassword(String name, String Password);

    @Transactional
    void deleteById(Integer id);

}
