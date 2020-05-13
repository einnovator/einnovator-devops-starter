package org.einnovator.devops.client.model;


public enum DeploymentStrategy {
	ROLLING_UPDATE("RollingUpdate"),
	RECREATE("Recreate")
	;
	
	private final String displayValue;

	DeploymentStrategy(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
	
	public static DeploymentStrategy parse(String s) {
		for (DeploymentStrategy e: DeploymentStrategy.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static DeploymentStrategy parse(String s, DeploymentStrategy defaultValue) {
		DeploymentStrategy value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
