package org.einnovator.devops.client.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.einnovator.util.CollectionUtil;
import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.security.Authority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProtectedEntity extends OwnedEntity {

	protected ShareType sharing;

	private List<Authority> authorities;	
	
	/**
	 * Create instance of {@code ProtectedEntity}.
	 *
	 */
	public ProtectedEntity() {
	}
	
	/**
	 * Create instance of {@code ProtectedEntity}.
	 *
	 * @param obj a prototype
	 */
	public ProtectedEntity(Object obj) {
		super(obj);
	}

	
	/**
	 * Get the value of property {@code sharing}.
	 *
	 * @return the sharing
	 */
	public ShareType getSharing() {
		return sharing;
	}

	/**
	 * Set the value of property {@code sharing}.
	 *
	 * @param sharing the value of property sharing
	 */
	public void setSharing(ShareType sharing) {
		this.sharing = sharing;
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
	 * @param authorities the value of property authorities
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code sharing}.
	 *
	 * @param sharing the value of property sharing
	 * @return this {@code ProtectedEntity}
	 */
	public ProtectedEntity withSharing(ShareType sharing) {
		this.sharing = sharing;
		return this;
	}

	/**
	 * Set the value of property {@code authorities}.
	 *
	 * @param authorities the value of property authorities
	 * @return this {@code ProtectedEntity}
	 */
	public ProtectedEntity withAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
		return this;
	}

	/**
	 * Set the value of property {@code authorities}.
	 *
	 * @param authorities a variadic array of authorities
	 * @return this {@code ProtectedEntity}
	 */
	public ProtectedEntity withAuthorities(Authority... authorities) {
		if (this.authorities==null) {
			this.authorities = new ArrayList<>();
		}
		this.authorities.addAll(Arrays.asList(authorities));
		return this;
	}


	//
	// Util
	//
	
	public boolean isPublic() {
		return getRequiredSharing()==ShareType.PUBLIC;
	}

	@JsonIgnore
	public ShareType getRequiredSharing() {
		return sharing!=null ? sharing : ShareType.PRIVATE;
	}

	//
	// Authorities
	//

	public boolean hasAuthorities() {
		return !CollectionUtil.isEmpty(authorities);
	}

	public void addAuthority(Authority authority) {
		if (authorities==null) {
			authorities = new ArrayList<Authority>();
		}
		authorities.add(authority);
	}

	public Authority removeAuthority(int index) {
		if (authorities==null || index <0 || index>= authorities.size()) {
			return null;
		}
		return authorities.remove(index);
	}

	public Authority getAuthority(int index) {
		List<Authority> authorities = getAuthorities();
		if (authorities==null || index <0 || index>= authorities.size()) {
			return null;
		}
		return authorities.get(index);
	}


	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("sharing", sharing)
				.append("authorities", getAuthorities())
				);
	}

	
}
