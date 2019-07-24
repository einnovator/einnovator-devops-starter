package org.einnovator.devops.client.model;


public enum OwnerType {
	USER("User"),
	GROUP("Group");
	
	private final String displayValue;

	OwnerType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static OwnerType parse(String s) {
		for (OwnerType e: OwnerType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static OwnerType parse(String s, OwnerType defaultValue) {
		OwnerType value = parse(s);
		return value!=null ? value: defaultValue;
	}
	

}
