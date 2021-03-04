package org.einnovator.devops.client.model;


public enum IngressType {
	NGINX("Nginx")
	;
	
	private final String displayValue;

	IngressType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static IngressType parse(String s) {
		for (IngressType e: IngressType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static IngressType parse(String s, IngressType defaultValue) {
		IngressType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
