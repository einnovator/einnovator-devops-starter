package org.einnovator.devops.client.model;


public enum RegistryType {
	DOCKER("Docker"),
	GIT("Git");

	
	private final String displayName;

	RegistryType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static RegistryType parse(String s) {
		for (RegistryType e: RegistryType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static RegistryType parse(String s, RegistryType defaultValue) {
		RegistryType value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
