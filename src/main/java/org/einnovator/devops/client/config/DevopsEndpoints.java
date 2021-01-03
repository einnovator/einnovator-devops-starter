package org.einnovator.devops.client.config;

public class DevopsEndpoints {

	//
	// Cluster
	//

	public static String cluster(String id, DevopsClientConfiguration config, boolean admin) {
		return clusters(config, admin) + "/" + id;
	}

	public static String clusters(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/cluster";
	}

	public static String clusterSpaces(String clusterId, DevopsClientConfiguration config, boolean admin) {
		return cluster(clusterId, config, admin) + "/space";
	}

	public static String clusterSpace(String clusterId, String spaceId, DevopsClientConfiguration config, boolean admin) {
		return clusterSpaces(clusterId, config, admin) + "/" + spaceId;
	}

	//
	// Space
	//

	public static String spaces(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/space";
	}

	public static String space(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/space/" + processId(spaceId);
	}

	public static String spaceSync(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/sync";
	}

	//
	// VolumeClaim
	//
	

	public static String volumeclaims(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/volumeclaim";
	}

	public static String volumeclaim(String spaceId, String volc, DevopsClientConfiguration config, boolean admin) {
		return volumeclaims(spaceId, config, admin) + "/" + volc;
	}

	//
	// Authority
	//
	
	public static String spaceAuths(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/auth";
	}

	public static String spaceAuth(String spaceId, String authId, DevopsClientConfiguration config, boolean admin) {
		return spaceAuths(spaceId, config, admin) + "/" + authId;
	}

	public static String spaceAuthResend(String spaceId, String authId, DevopsClientConfiguration config, boolean admin) {
		return spaceAuth(spaceId, authId, config, admin) + "/resend";
	}

	public static String spaceDeployments(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/deployment";
	}

	public static String spaceDeployment(String spaceId, String deployId, DevopsClientConfiguration config, boolean admin) {
		return spaceDeployments(spaceId, config, admin) + "/" + deployId;
	}

	public static String spaceJobs(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/job";
	}

	public static String spaceJob(String spaceId, String jobId, DevopsClientConfiguration config, boolean admin) {
		return spaceJobs(spaceId, config, admin) + "/" + jobId;
	}

	public static String spaceCronJobs(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/cronjob";
	}

	public static String spaceCronJob(String spaceId, String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return spaceCronJobs(spaceId, config, admin) + "/" + cronjobId;
	}

	public static String pods(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/pod";
	}

	public static String pod(String spaceId, String pod, DevopsClientConfiguration config, boolean admin) {
		return pods(spaceId, config, admin) + "/" + pod;
	}

	public static String replicasets(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/replicaset";
	}

	public static String replicaset(String spaceId, String replicaset, DevopsClientConfiguration config, boolean admin) {
		return replicasets(spaceId, config, admin) + "/" + replicaset;
	}


	//
	// Deployment
	//

	public static String deployments(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/deployment";
	}

	public static String deployment(String deployId, DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/deployment/" + processId(deployId);
	}

	public static String deploymentManifest(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/manifest.yaml";
	}

	public static String deploymentScale(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/scale";
	}

	public static String deploymentRScale(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/rscale";
	}

	public static String deploymentStart(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/start";
	}

	public static String deploymentRestart(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/restart";
	}

	public static String deploymentStop(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/stop";
	}

	public static String deploymentSync(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/sync";
	}

	public static String deploymentLog(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/logs";
	}

	public static String deploymentExec(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/exec";
	}

	public static String deploymentEvents(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/event";
	}
	
	public static String deploymentBuild(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/build";
	}

	public static String podsDeployment(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/pod";
	}

	public static String podDeployment(String deployId, String pod, DevopsClientConfiguration config, boolean admin) {
		return podsDeployment(deployId, config, admin) + "/" + pod;
	}

	public static String replicasetsDeployment(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/replicaset";
	}

	public static String replicasetDeployment(String deployId, String replicaset, DevopsClientConfiguration config, boolean admin) {
		return replicasetsDeployment(deployId, config, admin) + "/" + replicaset;
	}

	public static String routes(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/route";
	}

	public static String route(String deployId, String routeId, DevopsClientConfiguration config, boolean admin) {
		return routes(deployId, config, admin) + "/" + routeId;
	}

	public static String primaryRoute(String deployId, String routeId, DevopsClientConfiguration config, boolean admin) {
		return route(deployId, routeId, config, admin) + "/primary";
	}

	public static String bindings(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/binding";
	}

	public static String binding(String deployId, String bindingId, DevopsClientConfiguration config, boolean admin) {
		return bindings(deployId, config, admin) + "/" + bindingId;
	}

	public static String connectors(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/connector";
	}

	public static String connector(String deployId, String connectorId, DevopsClientConfiguration config, boolean admin) {
		return connectors(deployId, config, admin) + "/" + connectorId;
	}
	
	public static String mounts(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/mount";
	}

	public static String mount(String deployId, String mountId, DevopsClientConfiguration config, boolean admin) {
		return mounts(deployId, config, admin) + "/" + mountId;
	}

	public static String vars(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/env";
	}

	public static String var(String deployId, String varId, DevopsClientConfiguration config, boolean admin) {
		return vars(deployId, config, admin) + "/" + varId;
	}

	public static String repositories(String deployId, DevopsClientConfiguration config, boolean admin) {
		return deployment(deployId, config, admin) + "/repository";
	}

	public static String repository(String deployId, String repositoryId, DevopsClientConfiguration config, boolean admin) {
		return repositories(deployId, config, admin) + "/" + repositoryId;
	}

	//
	// Job
	//
	
	public static String jobs(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/job";
	}

	public static String job(String deployId, DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/job/" + processId(deployId);
	}

	public static String jobManifest(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/manifest.yaml";
	}

	public static String jobRScale(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/rscale";
	}

	public static String jobStart(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/start";
	}

	public static String jobRestart(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/restart";
	}

	public static String jobStop(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/stop";
	}

	public static String jobSync(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/sync";
	}

	public static String jobLog(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/logs";
	}

	public static String jobExec(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/exec";
	}

	public static String jobEvents(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/event";
	}

	public static String jobBuildJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/build";
	}
	
	public static String podsJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/pod";
	}

	public static String podJob(String jobId, String pod, DevopsClientConfiguration config, boolean admin) {
		return podsJob(jobId, config, admin) + "/" + pod;
	}

	public static String bindingsJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/binding";
	}

	public static String bindingJob(String jobId, String bindingId, DevopsClientConfiguration config, boolean admin) {
		return bindingsJob(jobId, config, admin) + "/" + bindingId;
	}

	public static String mountsJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/mount";
	}

	public static String mountJob(String jobId, String mountId, DevopsClientConfiguration config, boolean admin) {
		return mountsJob(jobId, config, admin) + "/" + mountId;
	}

	public static String varsJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return job(jobId, config, admin) + "/env";
	}

	public static String varJob(String jobId, String varId, DevopsClientConfiguration config, boolean admin) {
		return varsJob(jobId, config, admin) + "/" + varId;
	}

	//
	// CronJob
	//
	
	public static String cronjobs(String spaceId, DevopsClientConfiguration config, boolean admin) {
		return space(spaceId, config, admin) + "/cronjob";
	}

	public static String cronjob(String deployId, DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/cronjob/" + processId(deployId);
	}

	public static String cronjobManifest(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/manifest.yaml";
	}
	
	public static String cronjobRScale(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/rscale";
	}

	public static String cronjobStart(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/start";
	}

	public static String cronjobRestart(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/restart";
	}

	public static String cronjobStop(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/stop";
	}

	public static String cronjobSuspend(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/suspend";
	}

	public static String cronjobSync(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/sync";
	}

	public static String cronjobLog(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/logs";
	}

	public static String cronjobExec(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/exec";
	}
	
	public static String cronjobEvents(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/event";
	}

	public static String cronjobBuild(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/build";
	}
	
	public static String jobsCronJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(jobId, config, admin) + "/job";
	}

	public static String jobCronJob(String jobId, String pod, DevopsClientConfiguration config, boolean admin) {
		return jobsCronJob(jobId, config, admin) + "/" + pod;
	}
	
	public static String bindingsCronJob(String jobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(jobId, config, admin) + "/binding";
	}

	public static String bindingCronJob(String cronjobId, String bindingId, DevopsClientConfiguration config, boolean admin) {
		return bindingsCronJob(cronjobId, config, admin) + "/" + bindingId;
	}

	public static String mountsCronJob(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/mount";
	}

	public static String mountCronJob(String cronjobId, String mountId, DevopsClientConfiguration config, boolean admin) {
		return mountsCronJob(cronjobId, config, admin) + "/" + mountId;
	}

	public static String varsCronJob(String cronjobId, DevopsClientConfiguration config, boolean admin) {
		return cronjob(cronjobId, config, admin) + "/env";
	}

	public static String varCronJob(String cronjobId, String varId, DevopsClientConfiguration config, boolean admin) {
		return varsCronJob(cronjobId, config, admin) + "/" + varId;
	}
	//
	// Domain
	//

	public static String domain(String id, DevopsClientConfiguration config, boolean admin) {
		return domains(config, admin) + "/" + id;
	}

	public static String domains(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/domain";
	}

	//
	// Registry
	//

	public static String registry(String id, DevopsClientConfiguration config, boolean admin) {
		return registries(config, admin) + "/" + id;
	}

	public static String registries(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/registry";
	}
	
	//
	// Solution
	//
	
	public static String solutions(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/solution";
	}

	public static String solution(String id, DevopsClientConfiguration config, boolean admin) {
		return solutions(config, admin) + "/" + id;
	}

	public static String install(String id, DevopsClientConfiguration config, boolean admin) {
		return solution(id, config, admin) + "/install";
	}

	//
	// Catalog
	//
	
	public static String catalogs(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/catalog";
	}

	public static String catalog(String id, DevopsClientConfiguration config, boolean admin) {
		return catalogs(config, admin) + "/" + id;
	}

	public static String solutionsFor(String id, DevopsClientConfiguration config, boolean admin) {
		return catalog(id, config, admin) + "/solution";
	}

	public static String installFromCatalog(String catalogId, String solutionId, DevopsClientConfiguration config, boolean admin) {
		return catalog(catalogId, config, admin) + "/install/" + solutionId;
	}

	//
	// VCS
	//
	
	public static String vcs(String id, DevopsClientConfiguration config, boolean admin) {
		return vcss(config, admin) + "/" + id;
	}

	public static String vcss(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/vcs";
	}

	//
	// Billing
	//

	public static String billings(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/billing";
	}

	public static String billing(String id, DevopsClientConfiguration config, boolean admin) {
		return billings(config, admin) + "/" + id;
	}

	//
	// License
	//

	public static String licenses(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/license";
	}
	
	public static String license(String id, DevopsClientConfiguration config, boolean admin) {
		return licenses(config, admin) + "/" + id;
	}

	public static String api(DevopsClientConfiguration config, boolean admin) {
		String s = config.getServer() + "/api";
		if (admin) {
			s += "/admin";
		}
		return s;
	}
	
	
	
	private static String processId(String id) {
		return id.replaceAll("/", "@");
	}

	
}
