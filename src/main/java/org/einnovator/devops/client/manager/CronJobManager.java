package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.CronJob;
import org.einnovator.devops.client.modelx.CronJobOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;

public interface CronJobManager {
	
	//
	// CronJob CRUD
	//

	CronJob getCronJob(String id);
	
	CronJob getCronJob(String id, CronJobOptions options);
	
	CronJob updateCronJob(CronJob cronjob, RequestOptions options);
	
	boolean deleteCronJob(String id, RequestOptions options);

	//
	// Bindings
	//

	URI addBinding(String cronjobId, Binding binding, RequestOptions options);
	boolean removeBinding(String cronjobId, String bindingId, RequestOptions options);
	Binding updateBinding(String cronjobId, Binding binding, RequestOptions options);

	
	
	void onCronJobUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getCronJobCache();


}
