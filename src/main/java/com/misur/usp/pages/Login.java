package com.misur.usp.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.misur.usp.entities.User;

public class Login {

	@SessionState
	@Property
	private User user;

	@Inject
	private boolean userExists;

	@Property
	private User beanUser;

	@Inject
	private Session session;

	@Inject
	private AlertManager alert;

	@InjectComponent
	Zone zone;

	@CommitAfter
	Object onSuccess() {

		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", beanUser.getEmail()));
		cr.add(Restrictions.eq("password", beanUser.getPassword()));

		if (cr.list().size() > 0) {
			User results = (User) cr.list().get(0);
			System.out.println(results.toString());
			this.user = results;
			return null;
		} else {

			System.out.println("Greska");
		}

		return null;

	}

	public boolean isUserExists() {
		return userExists;
	}

	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}

}
