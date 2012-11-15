package com.misur.usp.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.misur.usp.entities.Trainer;



public class AddTrainer {
	@Property
	private  Trainer trainer;
	@Inject
	private Session session;
	@InjectComponent
	Zone zone;
	
	@CommitAfter
	Object onSuccess(){
			session.save(trainer);
		
		return null;
	}
	
}
