package it.eng.jpaday02.entity.partner;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FL")
public class NaturalEntity extends BusinessPartner implements Serializable{
	private static final long serialVersionUID = 19022021154100L;

	@Column(name = "personal_identity_number")
	private String personalIdentityNumber;
	private String firstname;
	private String lastname;
	
	public NaturalEntity() {
		// TODO Auto-generated constructor stub
	}

	public NaturalEntity(Long id, String personalIdentityNumber, String firstname, String lastname) {
		super(id);
		this.personalIdentityNumber = personalIdentityNumber;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public void setPersonalIdentityNumber(String personalIdentityNumber) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((personalIdentityNumber == null) ? 0 : personalIdentityNumber.hashCode());
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
		NaturalEntity other = (NaturalEntity) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (personalIdentityNumber == null) {
			if (other.personalIdentityNumber != null)
				return false;
		} else if (!personalIdentityNumber.equals(other.personalIdentityNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NaturalEntity [personalIdentityNumber=" + personalIdentityNumber + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
}
