package org.einnovator.devops.client.model;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endpoint extends EntityBase {

	protected String uri;

	protected Integer port;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Endpoint}.
	 *
	 */
	public Endpoint() {
	}
	
	//
	// Getters and setters
	//


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("uri", uri)
				.append("port", port)
				);
	}


	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return super.toString2(creator
				);
	}





}
