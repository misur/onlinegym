package com.misur.usp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;


@Entity
@Table(name = "akcije")
public class Akcije {

	@Id
	@NonVisual
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Validate("required")
	@Column(name = "nazivAkcije", nullable = false)
	private String nazivAkcije;
	
	@Validate("required")
	@Column(name="opisAkcije", nullable=false)
	private String opisAkcije;
	
	@Validate("required")
	@Column(name="brLjudi", nullable=false)
	private int brLjudi;
	
	
	@Validate("required")
	@Column(name="startDate", nullable=false)
	private Date start;
	
	
	@Validate("required")
	@Column(name="endDate", nullable=false)
	private Date end;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNazivAkcije() {
		return nazivAkcije;
	}


	public void setNazivAkcije(String nazivAkcije) {
		this.nazivAkcije = nazivAkcije;
	}


	public String getOpisAkcije() {
		return opisAkcije;
	}


	public void setOpisAkcije(String opisAkcije) {
		this.opisAkcije = opisAkcije;
	}


	public int getBrLjudi() {
		return brLjudi;
	}


	public void setBrLjudi(int brLjudi) {
		this.brLjudi = brLjudi;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}


	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}
	

	
	
}
