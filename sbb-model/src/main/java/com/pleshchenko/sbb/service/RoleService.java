package com.pleshchenko.sbb.service;

import com.pleshchenko.sbb.model.Role;

import java.util.List;

public interface RoleService {

    Role findById(int id);

    Role findByName(String name);

    List<Role> findAll();
}
