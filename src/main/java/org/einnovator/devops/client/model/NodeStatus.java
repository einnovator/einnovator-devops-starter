package org.einnovator.devops.client.model;


public enum NodeStatus {
	PROVISIONING("Provisioning"),
	STARTING("Starting"),
	RUNNING("Running"),
	STOPPED("Stopped"),
	HIBERNATED("Hibernated"),
	STOPPING("Stopping"),
	TERMINATING("Terminating"),
	TERMINATED("Terminated"),
	LOCKED("Locked"),
	;
	
	private final String displayValue;

	NodeStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static NodeStatus parse(String s) {
		for (NodeStatus e: NodeStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static NodeStatus parse(String s, NodeStatus defaultValue) {
		NodeStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
