package com.misur.usp.pages;

import java.util.LinkedList;
import java.util.List;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.Akcije;

public class PrikazAkcija {
	@Property
	private Akcije akcije;

	@InjectComponent
	private Zone zone;
	@Inject
	private Session session;

	LinkedList<Akcije> list = new LinkedList<Akcije>();

	public List<Akcije> getAkcijeLista() {
		return session.createCriteria(Akcije.class).list();
	}

	void onActivate() {
		getAkcijeLista();
	}
	

}
