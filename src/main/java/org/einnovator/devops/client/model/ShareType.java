package org.einnovator.devops.client.model;


public enum ShareType {
	PRIVATE("Private"),
	PUBLIC("Public"),
	RESTRICTED("Restricted"),
	ROLE("Role");
	
	private final String displayValue;

	ShareType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static ShareType parse(String s) {
		for (ShareType e: ShareType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ShareType parse(String s, ShareType defaultValue) {
		ShareType value = parse(s);
		return value!=null ? value: defaultValue;
	}
	

}
