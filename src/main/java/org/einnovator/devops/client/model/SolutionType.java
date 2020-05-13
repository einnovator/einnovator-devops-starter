package org.einnovator.devops.client.model;


public enum SolutionType {
	SIMPLE("Simple"),
	DEPLOYMENT("Deployment"),
	MANIFEST("Manifest"),
	EXTERNAL("External")
	;

	private final String displayValue;

	SolutionType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static SolutionType parse(String s) {
		for (SolutionType e: SolutionType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s) || e.getDisplayName().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static SolutionType parse(String s, SolutionType defaultValue) {
		SolutionType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
