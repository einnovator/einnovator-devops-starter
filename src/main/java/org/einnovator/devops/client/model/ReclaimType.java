package org.einnovator.devops.client.model;


public enum ReclaimType {
	RETAIN("Released"),
	DELETE("Bound"),
	RECYCLE("Recycle");
	
	private final String displayName;

	ReclaimType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static ReclaimType parse(String s) {
		for (ReclaimType e: ReclaimType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ReclaimType parse(String s, ReclaimType defaultValue) {
		ReclaimType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
