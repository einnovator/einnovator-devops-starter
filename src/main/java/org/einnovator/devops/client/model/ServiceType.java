package org.einnovator.devops.client.model;


public enum ServiceType {
	CLUSTER_IP("ClusterIP"),
	NODE_PORT("NodePort"),
	LOAD_BALANCER("LoadBalancer"),
	EXTERNAL_NAME("ExternalName");

	private final String displayValue;

	ServiceType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static ServiceType parse(String s) {
		for (ServiceType e: ServiceType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s) || e.getDisplayName().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ServiceType parse(String s, ServiceType defaultValue) {
		ServiceType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
