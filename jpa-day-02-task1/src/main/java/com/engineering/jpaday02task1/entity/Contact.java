package com.engineering.jpaday02task1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String fiksni;
	private String mobilni;
	private String web;
	private String linkedin;
	private String gitlab;
	
	@Column(name = "person_id")
	private Long personId;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String email, String fiksni, String mobilni, String web, String linkedin, String gitlab) {
		super();
		this.email = email;
		this.fiksni = fiksni;
		this.mobilni = mobilni;
		this.web = web;
		this.linkedin = linkedin;
		this.gitlab = gitlab;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFiksni() {
		return fiksni;
	}

	public void setFiksni(String fiksni) {
		this.fiksni = fiksni;
	}

	public String getMobilni() {
		return mobilni;
	}

	public void setMobilni(String mobilni) {
		this.mobilni = mobilni;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getGitlab() {
		return gitlab;
	}

	public void setGitlab(String gitlab) {
		this.gitlab = gitlab;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fiksni == null) ? 0 : fiksni.hashCode());
		result = prime * result + ((gitlab == null) ? 0 : gitlab.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkedin == null) ? 0 : linkedin.hashCode());
		result = prime * result + ((mobilni == null) ? 0 : mobilni.hashCode());
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((web == null) ? 0 : web.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fiksni == null) {
			if (other.fiksni != null)
				return false;
		} else if (!fiksni.equals(other.fiksni))
			return false;
		if (gitlab == null) {
			if (other.gitlab != null)
				return false;
		} else if (!gitlab.equals(other.gitlab))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkedin == null) {
			if (other.linkedin != null)
				return false;
		} else if (!linkedin.equals(other.linkedin))
			return false;
		if (mobilni == null) {
			if (other.mobilni != null)
				return false;
		} else if (!mobilni.equals(other.mobilni))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (web == null) {
			if (other.web != null)
				return false;
		} else if (!web.equals(other.web))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + ", fiksni=" + fiksni + ", mobilni=" + mobilni + ", web=" + web
				+ ", linkedin=" + linkedin + ", gitlab=" + gitlab + ", personId=" + personId + "]";
	}
	
	
}
