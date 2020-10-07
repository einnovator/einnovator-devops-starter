package org.einnovator.devops.client.model;


public enum LicenseStatus {
	PENDING("Pending"),
	READY("Ready"),
	ACTIVE("Active"),
	EXPIRED("Expired")
	;
	
	private final String displayValue;

	LicenseStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static LicenseStatus parse(String s) {
		for (LicenseStatus e: LicenseStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static LicenseStatus parse(String s, LicenseStatus defaultValue) {
		LicenseStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
