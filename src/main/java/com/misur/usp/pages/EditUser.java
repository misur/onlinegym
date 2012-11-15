package com.misur.usp.pages;


import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.User;


public class EditUser {

	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	

	@Property
	@Persist
	private User user;
	
	public User findByID(Long id) {
		if (id != null) {
			return (User) session.get(User.class, id);
		}
		return null;
	}

	Object onActivate (Long id){
		user = findByID(id);
		return null;
	}
	
	@CommitAfter
	Object onSuccess() {
		session.update(user);
		return null;
	}

}