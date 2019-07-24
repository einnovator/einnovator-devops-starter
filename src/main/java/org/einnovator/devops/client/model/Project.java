package org.einnovator.devops.client.model;

import java.util.List;

import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.security.Authority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project extends BilledEntity {

	
	protected List<Space> spaces;
	
	protected List<Authority> authorities;

	protected String channelId;	

	
	/**
	 * Create instance of {@code Project}.
	 *
	 */
	public Project() {
	}
	

	/**
	 * Create instance of {@code Project}.
	 *
	 * @param obj the prototype Object
	 */
	public Project(Object obj) {
		super(obj);
	}


	/**
	 * Get the value of property {@code spaces}.
	 *
	 * @return the spaces
	 */
	public List<Space> getSpaces() {
		return spaces;
	}


	/**
	 * Set the value of property {@code spaces}.
	 *
	 * @param spaces the spaces to set
	 */
	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}

	/**
	 * Get the value of property {@code authorities}.
	 *
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * Set the value of property {@code authorities}.
	 *
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}


	/**
	 * Get the value of property {@code channelId}.
	 *
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * Set the value of property {@code channelId}.
	 *
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	
	public Space findSpace(Space space) {
		if (space!=null && spaces!=null) {
			for (Space space2: spaces) {
				if ((space2.getId()!=null && space2.getId().equals(space.getId())) || (space2.getUuid()!=null && space2.getUuid().equals(space.getUuid()))) {
					return space;
				}
			}
		}
		return null;
	}

	public Space findSpace(String id) {
		if (id!=null && spaces!=null) {
			for (Space space: spaces) {
				if (id.equals(space.getUuid()) || id.equals(space.getKey())) {
					return space;
				}
			}
		}
		return null;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("spaces", spaces)
				.append("channelId", channelId)
				;
	}
	
	
}
