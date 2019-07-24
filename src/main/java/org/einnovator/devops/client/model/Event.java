package org.einnovator.devops.client.model;

import java.util.Date;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event extends EntityBase {

	private EventType type;

	private Date date;
	
	protected String description;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code TitleEntity}.
	 *
	 */
	public Event() {
	}

	public Event(EventType type) {
		this.type = type;
	}

	//
	// Getters and setters
	//

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
	 * Get the value of property {@code date}.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set the value of property {@code date}.
	 *
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("type", type)
				.append("date", date)
				.append("description", description)
				);
	}


	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				);
	}





}
