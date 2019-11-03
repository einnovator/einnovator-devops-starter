package org.einnovator.devops.client.model;


public enum RepositoryType {
	GIT("Git");
	
	private final String displayValue;

	RepositoryType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static RepositoryType parse(String s) {
		for (RepositoryType e: RepositoryType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static RepositoryType parse(String s, RepositoryType defaultValue) {
		RepositoryType value = parse(s);
		return value!=null ? value: defaultValue;
	}
	

}
