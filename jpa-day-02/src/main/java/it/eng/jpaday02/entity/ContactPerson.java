package it.eng.jpaday02.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact_person")
public class ContactPerson implements Serializable{
	private static final long serialVersionUID = 18022021154500L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	
//	@Column(name = "manufacturer_id")
//	private Long manufacturerId;
	
	@ManyToOne
	private Manufacturer manufacturer;
	
	public ContactPerson() {
		// TODO Auto-generated constructor stub
	}

	public ContactPerson(Long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "ContactPerson [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", manufacturer="
				+ manufacturer.getId() + "]";
	}

//	public Long getManufacturerId() {
//		return manufacturerId;
//	}
//
//	public void setManufacturerId(Long manufacturerId) {
//		this.manufacturerId = manufacturerId;
//	}
	
	
}
