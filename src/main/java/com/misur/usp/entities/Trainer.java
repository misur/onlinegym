package com.misur.usp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name="trainer")

public class Trainer {
	

		@Id
		@NonVisual
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column (name = "id")
		private long id;
		
		
		
		@Validate("required")
		@Column(name="name", nullable=false)
		private String name;
		
		
		@Validate("required")
		@Column(name="password", nullable=false)
		private String password;
		
		@Validate("required")
		@Column(name="type", nullable=false)
		private String type;
		
		
		
		@Validate("email,required")
		@Column(name="email", nullable=false)
		private String email;

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
}
