package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Catalog;
import org.einnovator.devops.client.modelx.CatalogFilter;
import org.einnovator.devops.client.modelx.CatalogOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface CatalogManager {
	
	/**
	 * Get {@code Catalog} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code Catalog} uuid
	 * @param options (optional) {@code CatalogOptions}
	 * @return the {@code Catalog} if found, or null if not found or request failed
	 */
	Catalog getCatalog(String id, CatalogOptions options);

	/**
	 * List {@code Catalog}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code CatalogFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Catalog}s, or null if request failed
	 */
	Page<Catalog> listCatalogs(CatalogFilter filter, Pageable pageable);

	/**
	 * Create Catalog.
	 * 
	 * @param vcs the {@code Catalog}
	 * @param options (optional) {@code RequestOptions}
	 * @return the {@code URI} for te created {@code Catalog}.
	 */
	URI createCatalog(Catalog vcs, RequestOptions options);
	
	/**
	 * Update existing {@code Catalog}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param vcs the {@code Catalog}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code Catalog}, or null if request failed
	 */
	Catalog updateCatalog(Catalog vcs, RequestOptions options);

	/**
	 * Create or Update Catalog.
	 * 
	 * If {@code Catalog.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param vcs the {@code Catalog}
	 * @param options (optional) {@code RequestOptions}
	 * @return the {@code Catalog} with {@code uuid} property set; or null if error.
	 */
	Catalog createOrUpdateCatalog(Catalog vcs, RequestOptions options);
	
	/**
	 * Delete existing {@code Catalog}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code Catalog} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code Catalog} was deleted, or false if request failed
	 */
	boolean deleteCatalog(String id, RequestOptions options);

	
	
	void onCatalogUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getCatalogCache();


}
