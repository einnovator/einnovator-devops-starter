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

	private String formattedDate;

	private String reason;

	private String description;

	private String username;

	private Object user;

	
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
	// Getters/Setters
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
	 * @param type the type
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
	 * @param date the date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Get the value of property {@code formattedDate}.
	 *
	 * @return the value of {@code formattedDate}
	 */
	public String getFormattedDate() {
		return formattedDate;
	}

	/**
	 * Set the value of property {@code formattedDate}.
	 *
	 * @param formattedDate the value of {@code formattedDate}
	 */
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	/**
	 * Get the value of property {@code reason}.
	 *
	 * @return the value of {@code reason}
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Set the value of property {@code reason}.
	 *
	 * @param reason the value of {@code reason}
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Get the value of property {@code username}.
	 *
	 * @return the value of {@code username}
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the value of {@code username}
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the value of property {@code user}.
	 *
	 * @return the value of {@code user}
	 */
	public Object getUser() {
		return user;
	}

	/**
	 * Set the value of property {@code user}.
	 *
	 * @param user the value of {@code user}
	 */
	public void setUser(Object user) {
		this.user = user;
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
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("type", type)
				.append("date", date)
				.append("username", username)
				.append("reason", reason)
				.append("description", description)
				);
	}

}
