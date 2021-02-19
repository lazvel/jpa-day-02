package it.eng.jpaday02.entity.partner;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Inheritance // klasa koja se nasledjuje
@DiscriminatorColumn(name = "partner_type")
@Table(name = "business_partner")
public abstract class BusinessPartner implements Serializable{
	private static final long serialVersionUID = 19022021153900L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public BusinessPartner() {
		// TODO Auto-generated constructor stub
	}
	
	public BusinessPartner(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
