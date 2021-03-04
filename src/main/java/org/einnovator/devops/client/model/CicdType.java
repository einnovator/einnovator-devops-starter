package org.einnovator.devops.client.model;


public enum CicdType {
	TEKTON("Tekton")
	;
	
	private final String displayValue;

	CicdType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static CicdType parse(String s) {
		for (CicdType e: CicdType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static CicdType parse(String s, CicdType defaultValue) {
		CicdType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
