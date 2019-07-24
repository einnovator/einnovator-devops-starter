package org.einnovator.devops.client.modelx;

import java.util.Date;

import org.einnovator.devops.client.model.EventType;
import org.einnovator.util.model.ToStringCreator;

public class EventFilter extends EventOptions {
	
	private String q;
	
	private Boolean strict;

	private EventType type;

	private Date fromDate;

	private Date toDate;

	public EventFilter() {
	}

	
	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}


	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}


	/**
	 * Get the value of property {@code strict}.
	 *
	 * @return the strict
	 */
	public Boolean getStrict() {
		return strict;
	}


	/**
	 * Set the value of property {@code strict}.
	 *
	 * @param strict the strict to set
	 */
	public void setStrict(Boolean strict) {
		this.strict = strict;
	}



	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}


	/**
	 * Get the value of property {@code fromDate}.
	 *
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}


	/**
	 * Set the value of property {@code fromDate}.
	 *
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	/**
	 * Get the value of property {@code toDate}.
	 *
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}


	/**
	 * Set the value of property {@code toDate}.
	 *
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("strict", strict)
				.append("type", type)
				.append("fromDate", fromDate)
				.append("toDate", toDate)
				;
	}
	
}
