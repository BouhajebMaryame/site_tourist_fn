package com.dao.impl;

import com.bo.Utilisateur;
import com.dao.UserDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

public class UserDaoImp  extends HibernateSpringGenericDaoImpl<Utilisateur, Long> implements UserDao{

	public UserDaoImp() {
		super(Utilisateur.class);
	}

}
