package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.modelx.VcsFilter;
import org.einnovator.devops.client.modelx.VcsOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface VcsManager {
	
	/**
	 * Get {@code Vcs} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code Vcs} uuid
	 * @return the {@code Vcs} if found, or null if not found or request failed
	 */
	Vcs getVcs(String id, VcsOptions options);

	/**
	 * List {@code Vcs}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code VcsFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Vcs}s, or null if request failed
	 */
	Page<Vcs> listVcss(VcsFilter filter, Pageable pageable);

	/**
	 * Create Vcs.
	 * 
	 * @param vcs the {@code Vcs}
	 * @param options TODO
	 * @return the {@code URI} for te created {@code Vcs}.
	 */
	URI createVcs(Vcs vcs, RequestOptions options);
	
	/**
	 * Update existing {@code Vcs}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param vcs the {@code Vcs}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code Vcs}, or null if request failed
	 */
	Vcs updateVcs(Vcs vcs, RequestOptions options);

	/**
	 * Create or Update Vcs.
	 * 
	 * If {@code Vcs.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param vcs the {@code Vcs}
	 * @param options TODO
	 * @return the {@code Vcs} with {@code uuid} property set; or null if error.
	 */
	Vcs createOrUpdateVcs(Vcs vcs, RequestOptions options);
	
	/**
	 * Delete existing {@code Vcs}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code Vcs} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code Vcs} was deleted, or false if request failed
	 */
	boolean deleteVcs(String id, RequestOptions options);

	
	
	void onVcsUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getVcsCache();


}
