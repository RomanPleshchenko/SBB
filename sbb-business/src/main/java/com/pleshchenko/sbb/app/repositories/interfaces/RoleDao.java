package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.authorization.Role;

import java.util.List;


public interface RoleDao {

	List<Role> findAll();

	Role findByType(String type);

	Role findById(int id);
}
