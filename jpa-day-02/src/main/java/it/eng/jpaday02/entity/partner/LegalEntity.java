package it.eng.jpaday02.entity.partner;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PL")
public class LegalEntity extends BusinessPartner implements Serializable{
	private static final long serialVersionUID = 19022021154000L;

	@Column(name = "company_identity_number")
	private String companyIdentityNumber;
	
	@Column(name = "tax_number")
	private String taxNumber;
	
	private String name;
	
	public LegalEntity() {
		// TODO Auto-generated constructor stub
	}

	public LegalEntity(Long id, String companyIdentityNumber, String taxNumber, String name) {
		super(id);
		this.companyIdentityNumber = companyIdentityNumber;
		this.taxNumber = taxNumber;
		this.name = name;
	}

	public String getCompanyIdentityNumber() {
		return companyIdentityNumber;
	}

	public void setCompanyIdentityNumber(String companyIdentityNumber) {
		this.companyIdentityNumber = companyIdentityNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyIdentityNumber == null) ? 0 : companyIdentityNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((taxNumber == null) ? 0 : taxNumber.hashCode());
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
		LegalEntity other = (LegalEntity) obj;
		if (companyIdentityNumber == null) {
			if (other.companyIdentityNumber != null)
				return false;
		} else if (!companyIdentityNumber.equals(other.companyIdentityNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taxNumber == null) {
			if (other.taxNumber != null)
				return false;
		} else if (!taxNumber.equals(other.taxNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LegalEntity [companyIdentityNumber=" + companyIdentityNumber + ", taxNumber=" + taxNumber + ", name="
				+ name + "]";
	}
	
}
