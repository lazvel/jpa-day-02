package it.eng.jpaday022.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
	@NamedQuery(name = "Person.findAllByCity", query = "SELECT p FROM Person p WHERE City.name = ? ")
})
public class Person {
	private static final long serialVersionUID = 18022021111900L;
	
	@Id
	@Column(name = "pId")
	private long personalIdentityNumber;
	private String firstname;
	private String lastname;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private City city;
	
	public Person() {
		
	}

	public Person(long personalIdentityNumber, String firstname, String lastname, City city) {
		super();
		this.personalIdentityNumber = personalIdentityNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
	}

	public long getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(long personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [personalIdentityNumber=" + personalIdentityNumber + ", firstname=" + firstname + ", lastname="
				+ lastname + ", city=" + city + "]";
	}
	
}
