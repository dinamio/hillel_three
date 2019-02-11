package com.documents.hw_6.dao;

import com.documents.hw_6.entity.Role;
import com.documents.hw_6.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface SpringDataRoleDao extends CrudRepository<Role, Integer> {
    Role findRoleByRole(String role);
}