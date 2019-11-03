package org.einnovator.devops.client.config;

public class DevopsEndpoints {
	
	public static String project(String id, DevopsClientConfiguration config) {
		return projects(config) + "/" + id;
	}

	public static String projects(DevopsClientConfiguration config) {
		return config.getServer() + "/api/project";
	}

	public static String domain(String id, DevopsClientConfiguration config) {
		return domains(config) + "/" + id;
	}

	public static String domains(DevopsClientConfiguration config) {
		return config.getServer() + "/api/domain";
	}

	public static String registry(String id, DevopsClientConfiguration config) {
		return registrys(config) + "/" + id;
	}

	public static String registrys(DevopsClientConfiguration config) {
		return config.getServer() + "/api/registry";
	}

	public static String cluster(String id, DevopsClientConfiguration config) {
		return clusters(config) + "/" + id;
	}

	public static String clusters(DevopsClientConfiguration config) {
		return config.getServer() + "/api/cluster";
	}

	public static String spaces(String projectId, DevopsClientConfiguration config) {
		return project(projectId, config) + "/spaces";
	}

	public static String spaces(DevopsClientConfiguration config) {
		return config.getServer() + "/api/space";
	}

	public static String space(String spaceId, DevopsClientConfiguration config) {
		return  config.getServer() + "/api/space/" + spaceId;
	}

	public static String deployments(String spaceId, DevopsClientConfiguration config) {
		return space(spaceId, config) + "/deployment";
	}

	public static String deployment(String deployId, DevopsClientConfiguration config) {
		return config.getServer() + "/api/deployment/" + deployId;
	}
	
	public static String routes(String deployId, DevopsClientConfiguration config) {
		return deployment(deployId, config) + "/route";
	}

	public static String route(String deployId, String routeId, DevopsClientConfiguration config) {
		return  routes(deployId, config) +"/" + routeId;
	}

	public static String bindings(String deployId, DevopsClientConfiguration config) {
		return deployment(deployId, config) + "/binding";
	}

	public static String binding(String deployId, String bindingId, DevopsClientConfiguration config) {
		return  bindings(deployId, config) +"/" + bindingId;
	}

	public static String connectors(String deployId, DevopsClientConfiguration config) {
		return deployment(deployId, config) + "/connector";
	}

	public static String connector(String deployId, String connectorId, DevopsClientConfiguration config) {
		return  connectors(deployId, config) +"/" + connectorId;
	}

	public static String repositories(String deployId, DevopsClientConfiguration config) {
		return deployment(deployId, config) + "/repository";
	}

	public static String repository(String deployId, String repositoryId, DevopsClientConfiguration config) {
		return  repositories(deployId, config) +"/" + repositoryId;
	}

	public static String volumeclaims(String spaceId, DevopsClientConfiguration config) {
		return space(spaceId, config) + "/volumeclaim";
	}
	
	public static String solutions(String spaceId, DevopsClientConfiguration config) {
		return space(spaceId, config) + "/solution";
	}

	public static String solution(String deployId, DevopsClientConfiguration config) {
		return config.getServer() + "/api/solution/" + deployId;
	}

	public static String billing(String id, DevopsClientConfiguration config) {
		return billings(config) + "/" + id;
	}

	public static String billings(DevopsClientConfiguration config) {
		return config.getServer() + "/api/billing";
	}
	
	public static String vcs(String id, DevopsClientConfiguration config) {
		return vcss(config) + "/" + id;
	}

	public static String vcss(DevopsClientConfiguration config) {
		return config.getServer() + "/api/vcs";
	}
}
