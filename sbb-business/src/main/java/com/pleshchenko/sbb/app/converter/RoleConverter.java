package com.pleshchenko.sbb.app.converter;

import com.pleshchenko.sbb.app.entity.authorization.Role;
import com.pleshchenko.sbb.app.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleConverter implements Converter<Object, Role> {

//	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	RoleService roleService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(Object)
	 */
	public Role convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Role role= roleService.findById(id);
//		logger.info("Profile : {}",profile);
		return role;
	}
	
}