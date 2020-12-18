package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Domain;
import org.einnovator.devops.client.modelx.DomainFilter;
import org.einnovator.devops.client.modelx.DomainOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface DomainManager {
	
	/**
	 * Get {@code Domain} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code Domain} uuid
	 * @return the {@code Domain} if found, or null if not found or request failed
	 */
	Domain getDomain(String id, DomainOptions options);

	/**
	 * List {@code Domain}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code DomainFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Domain}s, or null if request failed
	 */
	Page<Domain> listDomains(DomainFilter filter, Pageable pageable);

	/**
	 * Create Domain.
	 * 
	 * @param dolution the {@code Domain}
	 * @param options optional {@code RequestOptions}
	 * @return the {@code URI} for te created {@code Domain}.
	 */
	URI createDomain(Domain dolution, RequestOptions options);
	
	/**
	 * Update existing {@code Domain}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param dolution the {@code Domain}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code Domain}, or null if request failed
	 */
	Domain updateDomain(Domain dolution, RequestOptions options);

	/**
	 * Create or Update Domain.
	 * 
	 * If {@code Domain.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param dolution the {@code Domain}
	 * @param options optional {@code RequestOptions}
	 * @return the {@code Domain} with {@code uuid} property set; or null if error.
	 */
	Domain createOrUpdateDomain(Domain dolution, RequestOptions options);
	
	/**
	 * Delete existing {@code Domain}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code Domain} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code Domain} was deleted, or false if request failed
	 */
	boolean deleteDomain(String id, RequestOptions options);

	
	
	void onDomainUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getDomainCache();


}
