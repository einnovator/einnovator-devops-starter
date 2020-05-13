package org.einnovator.devops.client.model;


public enum DeploymentKind {
	DEPLOYMENT("Deployment"),
	REPLICA_SET("ReplicaSet"),
	STATEFUL_SET("StatefulSet"),
	DAEMON_SET("DaemonSet"),
	POD("Pod"),
	;
	
	private final String displayValue;

	DeploymentKind(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public static DeploymentKind parse(String s) {
		for (DeploymentKind e: DeploymentKind.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static DeploymentKind parse(String s, DeploymentKind defaultValue) {
		DeploymentKind value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
