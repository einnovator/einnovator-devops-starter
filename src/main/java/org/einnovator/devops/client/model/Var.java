package org.einnovator.devops.client.model;

import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Var extends Variable {

	public Var() {
	}
	

	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator);
	}
	
}
