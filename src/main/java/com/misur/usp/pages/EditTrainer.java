package com.misur.usp.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.Trainer;

public class EditTrainer {
	@Inject
	private Session session;

	@InjectComponent
	private Zone zone;

	

	@Property
	@Persist
	private Trainer trainer;
	
	public Trainer findByID(Long id) {
		if (id != null) {
			return (Trainer) session.get(Trainer.class, id);
		}
		return null;
	}

	Object onActivate (Long id){
		trainer = findByID(id);
		return null;
	}
	
	@CommitAfter
	Object onSuccess() {
		session.update(trainer);
		return null;
	}
}
