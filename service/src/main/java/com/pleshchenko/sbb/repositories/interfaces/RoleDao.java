package com.pleshchenko.sbb.repositories.interfaces;

import com.pleshchenko.sbb.model.entity.authorization.Role;

import java.util.List;

public interface RoleDao {

	Role findById(int id);

	Role findByName(String name);

	List<Role> findAll();

}
