package org.einnovator.devops.client.model;


public enum RuntimeStatus {
	INSTALLED("Installed"),
	NOT_DETECTED("Not Detected"),
	UNKNOWN("Unknow"),
	ERROR("Error");
	
	private final String displayValue;

	RuntimeStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public static RuntimeStatus parse(String s) {
		for (RuntimeStatus e: RuntimeStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static RuntimeStatus parse(String s, RuntimeStatus defaultValue) {
		RuntimeStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
