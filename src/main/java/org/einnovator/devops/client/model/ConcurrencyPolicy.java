package org.einnovator.devops.client.model;


public enum ConcurrencyPolicy {
	ALLOW("Allow"),
	FORBID("Forbid"),
	REPLACE("Replace");

	private final String displayValue;

	ConcurrencyPolicy(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}


	public static ConcurrencyPolicy parse(String s) {
		for (ConcurrencyPolicy e: ConcurrencyPolicy.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ConcurrencyPolicy parse(String s, ConcurrencyPolicy defaultValue) {
		ConcurrencyPolicy value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
