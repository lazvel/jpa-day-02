package it.eng.jpaday02.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer implements Serializable{
	private static final long serialVersionUID = 18022021095100L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_number")
	private City city;
	
	// preslikavanje, unidirekciona veza
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true) // ako brisem proizvodjaca da se obrise i kontakt osoba za tog proizvodjaca
//	@JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
//	private List<ContactPerson> contactPersons;
	
	@OneToMany(mappedBy = "manufacturer",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ContactPerson> contactPersons;
	
	public Manufacturer() {
		contactPersons = new ArrayList<ContactPerson>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	public void addContactPerson(ContactPerson contactPerson) {
		contactPersons.add(contactPerson);
		contactPerson.setManufacturer(this);
	}
}
