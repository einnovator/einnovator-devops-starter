package org.einnovator.devops.client.model;


public enum Scope {
	PROJECT("Project"),
	SPACE("Space"),
	DEPLOYMENT("Deployment"),
	CLUSTER("Cluster");
	
	private final String displayValue;

	Scope(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static Scope parse(String s) {
		for (Scope e: Scope.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static Scope parse(String s, Scope defaultValue) {
		Scope value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
