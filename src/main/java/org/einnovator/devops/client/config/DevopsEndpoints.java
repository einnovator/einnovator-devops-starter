package org.einnovator.devops.client.config;

public class DevopsEndpoints {
	
	public static String domain(String id, DevopsClientConfiguration config,  boolean admin) {
		return domains(config, admin) + "/" + id;
	}

	public static String domains(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/domain";
	}

	public static String registry(String id, DevopsClientConfiguration config,  boolean admin) {
		return registries(config, admin) + "/" + id;
	}

	public static String registries(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/registry";
	}

	public static String cluster(String id, DevopsClientConfiguration config,  boolean admin) {
		return clusters(config, admin) + "/" + id;
	}

	public static String clusters(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/cluster";
	}

	public static String spaces(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/space";
	}

	public static String space(String spaceId, DevopsClientConfiguration config,  boolean admin) {
		return  api(config, admin) + "/space/" + spaceId;
	}

	public static String deployments(String spaceId, DevopsClientConfiguration config,  boolean admin) {
		return space(spaceId, config, admin) + "/deployment";
	}

	public static String deployment(String deployId, DevopsClientConfiguration config,  boolean admin) {
		return api(config, admin) + "/deployment/" + deployId;
	}
	
	public static String routes(String deployId, DevopsClientConfiguration config,  boolean admin) {
		return deployment(deployId, config, admin) + "/route";
	}

	public static String route(String deployId, String routeId, DevopsClientConfiguration config,  boolean admin) {
		return  routes(deployId, config, admin) +"/" + routeId;
	}

	public static String bindings(String deployId, DevopsClientConfiguration config,  boolean admin) {
		return deployment(deployId, config, admin) + "/binding";
	}

	public static String binding(String deployId, String bindingId, DevopsClientConfiguration config,  boolean admin) {
		return  bindings(deployId, config, admin) +"/" + bindingId;
	}

	public static String connectors(String deployId, DevopsClientConfiguration config,  boolean admin) {
		return deployment(deployId, config, admin) + "/connector";
	}

	public static String connector(String deployId, String connectorId, DevopsClientConfiguration config,  boolean admin) {
		return connectors(deployId, config, admin) + "/" + connectorId;
	}

	public static String repositories(String deployId, DevopsClientConfiguration config,  boolean admin) {
		return deployment(deployId, config, admin) + "/repository";
	}

	public static String repository(String deployId, String repositoryId, DevopsClientConfiguration config,  boolean admin) {
		return repositories(deployId, config, admin) +"/" + repositoryId;
	}

	public static String volumeclaims(String spaceId, DevopsClientConfiguration config,  boolean admin) {
		return space(spaceId, config, admin) + "/volumeclaim";
	}
	
	public static String solutions(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/solution";
	}

	public static String solution(String id, DevopsClientConfiguration config,  boolean admin) {
		return solutions(config, admin) + "/" + id;
	}

	public static String catalogs(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/catalog";
	}

	public static String catalog(String id, DevopsClientConfiguration config, boolean admin) {
		return catalogs(config, admin) + "/" + id;
	}

	public static String billing(String id, DevopsClientConfiguration config, boolean admin) {
		return billings(config, admin) + "/" + id;
	}

	public static String billings(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/billing";
	}
	
	public static String vcs(String id, DevopsClientConfiguration config,  boolean admin) {
		return vcss(config, admin) + "/" + id;
	}

	public static String vcss(DevopsClientConfiguration config, boolean admin) {
		return api(config, admin) + "/vcs";
	}
	
	public static String api(DevopsClientConfiguration config, boolean admin) {
		String s = config.getServer() + "/api";
		if (admin) {
			s += "/admin";
		}
		return s;
	}
}
