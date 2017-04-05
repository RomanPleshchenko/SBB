package com.pleshchenko.sbb.service.interfaces;

import com.pleshchenko.sbb.model.model.entity.authorization.Role;

import java.util.List;

public interface RoleService {

    Role findById(int id);

    Role findByName(String name);

    List<Role> findAll();
}
