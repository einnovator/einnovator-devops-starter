package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;


import org.einnovator.devops.client.model.License;
import org.einnovator.devops.client.modelx.LicenseFilter;
import org.einnovator.devops.client.modelx.LicenseOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface LicenseManager {
	
	/**
	 * Get {@code License} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code License} uuid
	 * @return the {@code License} if found, or null if not found or request failed
	 */
	License getLicense(String id, LicenseOptions options);

	/**
	 * List {@code License}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code LicenseFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code License}s, or null if request failed
	 */
	Page<License> listLicenses(LicenseFilter filter, Pageable pageable);

	/**
	 * Create License.
	 * 
	 * @param license the {@code License}
	 * @param options TODO
	 * @return the {@code URI} for te created {@code License}.
	 */
	URI createLicense(License license, RequestOptions options);
	
	/**
	 * Update existing {@code License}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param license the {@code License}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code License}, or null if request failed
	 */
	License updateLicense(License license, RequestOptions options);

	/**
	 * Create or Update License.
	 * 
	 * If {@code License.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param license the {@code License}
	 * @param options TODO
	 * @return the {@code License} with {@code uuid} property set; or null if error.
	 */
	License createOrUpdateLicense(License license, RequestOptions options);
	
	/**
	 * Delete existing {@code License}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code License} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code License} was deleted, or false if request failed
	 */
	boolean deleteLicense(String id, RequestOptions options);

	
	
	void onLicenseUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getLicenseCache();


}
