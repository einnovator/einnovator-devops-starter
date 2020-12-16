package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Solution;
import org.einnovator.devops.client.modelx.SolutionFilter;
import org.einnovator.devops.client.modelx.SolutionOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.client.RestClientException;

public interface SolutionManager {
	
	/**
	 * Get {@code Solution} with specified identifier.
	 * 
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param id the {@code Solution} uuid
	 * @return the {@code Solution} if found, or null if not found or request failed
	 */
	Solution getSolution(String id, SolutionOptions options);

	/**
	 * List {@code Solution}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Admin or owner.
	 * 
	 * @param filter a {@code SolutionFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Solution}s, or null if request failed
	 */
	Page<Solution> listSolutions(SolutionFilter filter, Pageable pageable);

	/**
	 * Create Solution.
	 * 
	 * @param solution the {@code Solution}
	 * @param options TODO
	 * @return the {@code URI} for te created {@code Solution}.
	 */
	URI createSolution(Solution solution, RequestOptions options);
	
	/**
	 * Update existing {@code Solution}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param solution the {@code Solution}
	 * @param options optional {@code RequestOptions}
	 * @return the same {@code Solution}, or null if request failed
	 */
	Solution updateSolution(Solution solution, RequestOptions options);

	/**
	 * Create or Update Solution.
	 * 
	 * If {@code Solution.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param solution the {@code Solution}
	 * @param options TODO
	 * @return the {@code Solution} with {@code uuid} property set; or null if error.
	 */
	Solution createOrUpdateSolution(Solution solution, RequestOptions options);
	
	/**
	 * Delete existing {@code Solution}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * @param id the {@code Solution} identifier
	 * @param options optional {@code RequestOptions}
	 * @return true if {@code Solution} was deleted, or false if request failed
	 */
	boolean deleteSolution(String id, RequestOptions options);

	
	
	void onSolutionUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getSolutionCache();


}
