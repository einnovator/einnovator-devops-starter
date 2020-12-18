package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Registry;
import org.einnovator.devops.client.modelx.RegistryFilter;
import org.einnovator.devops.client.modelx.RegistryOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface RegistryManager {
	
	/**
	 * Get {@code Registry} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code Registry} uuid
	 * @return the {@code Registry} if found, or null if not found or request failed
	 */
	Registry getRegistry(String id, RegistryOptions options);

	/**
	 * List {@code Registry}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code RegistryFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Registry}s, or null if request failed
	 */
	Page<Registry> listRegistries(RegistryFilter filter, Pageable pageable);

	/**
	 * Create Registry.
	 * 
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @return the {@code URI} for te created {@code Registry}.
	 */
	URI createRegistry(Registry registry, RequestOptions options);
	
	/**
	 * Update existing {@code Registry}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code Registry}, or null if request failed
	 */
	Registry updateRegistry(Registry registry, RequestOptions options);

	/**
	 * Create or Update Registry.
	 * 
	 * If {@code Registry.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param registry the {@code Registry}
	 * @param options optional {@code RequestOptions}
	 * @return the {@code Registry} with {@code uuid} property set; or null if error.
	 */
	Registry createOrUpdateRegistry(Registry registry, RequestOptions options);
	
	/**
	 * Delete existing {@code Registry}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code Registry} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code Registry} was deleted, or false if request failed
	 */
	boolean deleteRegistry(String id, RequestOptions options);

	
	
	void onRegistryUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getRegistryCache();


}
