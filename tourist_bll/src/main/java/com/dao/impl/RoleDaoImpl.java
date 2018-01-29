package com.dao.impl;

import com.bo.Role_tourist;
import com.dao.RoleDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

public class RoleDaoImpl extends HibernateSpringGenericDaoImpl<Role_tourist, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role_tourist.class);
		
	}

}
