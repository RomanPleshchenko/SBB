package com.pleshchenko.sbb.model.dao;

import com.pleshchenko.sbb.model.model.Role;

import java.util.List;

public interface RoleDao {

	Role findById(int id);

	Role findByName(String name);

	List<Role> findAll();

}
