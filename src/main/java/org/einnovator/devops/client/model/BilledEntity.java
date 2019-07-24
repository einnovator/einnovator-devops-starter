package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BilledEntity extends ProtectedEntity {



	/**
	 * Create instance of {@code OwnedEntity}.
	 *
	 */
	public BilledEntity() {
	}
	
	

	/**
	 * Create instance of {@code BilledEntity}.
	 *
	 * @param obj the prototype Object
	 */
	public BilledEntity(Object obj) {
		super(obj);
	}

	
	private Bill bill;


	/**
	 * Get the value of property {@code bill}.
	 *
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}


	/**
	 * Set the value of property {@code bill}.
	 *
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(
				creator.append("bill", bill)
				);
	}
	
}
