package com.pleshchenko.sbb.dao;

import com.pleshchenko.sbb.model.Role;

import java.util.List;

public interface RoleDao {

	Role findById(int id);

	Role findByName(String name);

	List<Role> findAll();

}
