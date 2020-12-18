package org.einnovator.devops.client.manager;


import java.net.URI;
import java.util.Map;

import org.einnovator.devops.client.model.Binding;
import org.einnovator.devops.client.model.Job;
import org.einnovator.devops.client.modelx.JobOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.cache.Cache;

public interface JobManager {
	
	//
	// Job CRUD
	//

	Job getJob(String id);
	
	Job getJob(String id, JobOptions options);
	
	Job updateJob(Job job, RequestOptions options);
	
	boolean deleteJob(String id, RequestOptions options);

	//
	// Bindings
	//

	URI addBinding(String jobId, Binding binding, RequestOptions options);
	boolean removeBinding(String jobId, String bindingId, RequestOptions options);
	Binding updateBinding(String jobId, String bindingId, Binding binding, RequestOptions options);

	
	
	void onJobUpdate(String id, Map<String, Object> details);

	void clearCache();
	
	Cache getJobCache();


}
