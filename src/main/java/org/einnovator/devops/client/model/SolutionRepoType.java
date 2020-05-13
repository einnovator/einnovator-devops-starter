package org.einnovator.devops.client.model;


public enum SolutionRepoType {
	HELM("Helm"),
	NATIVE("Native");
	
	private final String displayValue;

	SolutionRepoType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static SolutionRepoType parse(String s) {
		for (SolutionRepoType e: SolutionRepoType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static SolutionRepoType parse(String s, SolutionRepoType defaultValue) {
		SolutionRepoType value = parse(s);
		return value!=null ? value: defaultValue;
	}
	

}
