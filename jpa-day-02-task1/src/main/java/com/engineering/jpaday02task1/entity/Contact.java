package com.engineering.jpaday02task1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact implements Serializable{
	private static final long serialVersionUID = 19022021100200L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING) // ordinal brojeve 1, 2, 3
	private ContactType type;
	
	private String value;
	
//	@Column(name = "person_id")
//	private Long personId;
	
	@ManyToOne
	private Person person;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	// sva polja pa tamo gde ne treba stavicemo null
	public Contact(Long id, ContactType type, String value ) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

//	public Long getPersonId() {
//		return personId;
//	}
//
//	public void setPersonId(Long personId) {
//		this.personId = personId;
//	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", value=" + value + ", person=" + person + "]";
	}
	
	
	
}
