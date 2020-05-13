package org.einnovator.devops.client.model;


public enum AccessMode {
	READ_ONLY_MANY("ReadOnlyMany"),
	READ_WRITE_ONCE("ReadWriteOnce"),
	READ_WRITE_MANY("ReadWriteMany");
	
	private final String displayValue;

	AccessMode(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static AccessMode parse(String s) {
		for (AccessMode e: AccessMode.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static AccessMode parse(String s, AccessMode defaultValue) {
		AccessMode value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
