package com.misur.usp.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.Trainer;


public class BrowseTrainer {
	@Property
	private Trainer	 trainer;
	
	@InjectComponent
	private Zone zone;
	@Inject
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<Trainer> getTrainers() {
		return session.createCriteria(Trainer.class).list();
	}
	
	public Trainer findByID(Long id) {
		if (id != null) {
			return (Trainer) session.get(Trainer.class, id);
		}
		return null;
	}

	@CommitAfter
	Object onActionFromDelete(Long userId) {
		Trainer t = findByID(userId);
		if (t != null) {
			session.delete(t);
			return Index.class;
		}
		return null;
	}
}