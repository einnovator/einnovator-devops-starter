package org.einnovator.devops.client.modelx;

import java.util.Date;

import org.einnovator.devops.client.model.EventType;
import org.einnovator.util.model.ToStringCreator;

/**
 * A filter for {@code Event}s.
 *
 * @see Event
 * @author support@einnovator.org
 *
 */
public class EventFilter extends EventOptions {
	
	private String q;
	
	private EventType type;

	private Date fromDate;

	private Date toDate;

	/**
	 * Create instance of {@code EventFilter}.
	 *
	 */
	public EventFilter() {
	}


	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the value of q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of q
	 */
	public void setQ(String q) {
		this.q = q;
	}
	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the value of type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of type
	 */
	public void setType(EventType type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code fromDate}.
	 *
	 * @return the value of fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}


	/**
	 * Set the value of property {@code fromDate}.
	 *
	 * @param fromDate the value of fromDate
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	/**
	 * Get the value of property {@code toDate}.
	 *
	 * @return the value of toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Set the value of property {@code toDate}.
	 *
	 * @param toDate the value of toDate
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	//
	// With
	//
	
	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the value of property q
	 * @return this {@code EventFilter}
	 */
	public EventFilter withQ(String q) {
		this.q = q;
		return this;
	}

	/**
	 * Set the value of property {@code fromDate}.
	 *
	 * @param fromDate the value of property fromDate
	 * @return this {@code EventFilter}
	 */
	public EventFilter withFromDate(Date fromDate) {
		this.fromDate = fromDate;
		return this;
	}


	/**
	 * Set the value of property {@code toDate}.
	 *
	 * @param toDate the value of property toDate
	 * @return this {@code EventFilter}
	 */
	public EventFilter withToDate(Date toDate) {
		this.toDate = toDate;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return creator
				.append("q", q)
				.append("type", type)
				.append("fromDate", fromDate)
				.append("toDate", toDate)
				;
	}
	
}
