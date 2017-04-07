package com.pleshchenko.sbb.web.converter;

import com.pleshchenko.sbb.model.model.entity.authorization.Role;
import com.pleshchenko.sbb.service.dto.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;

    @Override
    public Role convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Role profile = roleService.findById(id);
        System.out.println("Profile : "+profile);
        return profile;
    }
}
