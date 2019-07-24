package org.einnovator.devops.client.model;


public enum DeploymentStatus {
	CREATED("Created"),
	STARTING("Starting"),
	RUNNING("Running"),
	SHUTTING_DOWN("Shutting Down"),
	TERMINATING("Terminating"),
	STOPPED("Stopped"),
	ERROR("Error");
	
	private final String displayValue;

	DeploymentStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static DeploymentStatus parse(String s) {
		for (DeploymentStatus e: DeploymentStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static DeploymentStatus parse(String s, DeploymentStatus defaultValue) {
		DeploymentStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

	/**
	 * @return
	 */
	public boolean isActive() {
		switch (this) {
		case RUNNING: case STARTING:
			return true;
		default:
			break;		
		}
		return false;
	}

}
