package it.eng.jpaday022.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
	private static final long serialVersionUID = 18022021111800L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long number;
	private String name;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public City(long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", number=" + number + ", name=" + name + "]";
	}
	
	
}
