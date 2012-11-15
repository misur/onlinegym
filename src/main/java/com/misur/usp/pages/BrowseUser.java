package com.misur.usp.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.internal.services.PageActivator;
import org.apache.tapestry5.internal.structure.Page;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.User;

public class BrowseUser {
	@Property
	private User user;
	
	@InjectComponent
	private Zone zone;
	@Inject
	private Session session;
	
	public List<User> getUsers() {
		return session.createCriteria(User.class).list();
	}
	
	public User findByID(Long id) {
		if (id != null) {
			return (User) session.get(User.class, id);
		}
		return null;
	}

	@CommitAfter
	Object onActionFromDelete(Long userId) {
		User u = findByID(userId);
		if (u != null) {
			session.delete(u);
			return Index.class;
		}
		return null;
	}
}
