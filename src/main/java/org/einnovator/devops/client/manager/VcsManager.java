package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Vcs;
import org.einnovator.devops.client.modelx.VcsFilter;
import org.einnovator.devops.client.modelx.VcsOptions;
import org.springframework.cache.Cache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VcsManager {
	
	Vcs getVcs(String id);
	
	Vcs getVcs(String id, VcsOptions options);

	Page<Vcs> listVcss(VcsFilter filter, Pageable pageable);

	/**
	 * Create Vcs.
	 * 
	 * @param project the {@code Vcs}
	 * @return the {@code URI} for te created {@code Vcs}.
	 */

	URI createVcs(Vcs project);
	
	Vcs updateVcs(Vcs project);
	

	/**
	 * Create or Update Vcs.
	 * 
	 * If {@code Vcs.uuid} has text is assumed to be an edit. Otherwise a create. A single call is made to seerver.
	 * @param project the {@code Vcs}
	 * @return the {@code Vcs} with {@code uuid} property set; or null if error.
	 */
	Vcs createOrUpdateVcs(Vcs project);
	
	boolean deleteVcs(String id);

	void onVcsUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getVcsCache();


}
