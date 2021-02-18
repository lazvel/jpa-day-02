package it.eng.jpaday02.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
	@NamedQuery(name = "City.findAllOrderByName", query = "SELECT c FROM City c ORDER BY c.name")
})
// @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
public class City implements Serializable{
	private static final long serialVersionUID = 18022021084200L;
	@Id
	private Long number;
	private String name;
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public City(Long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
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
		return "City [number=" + number + ", name=" + name + "]";
	}
	
}
