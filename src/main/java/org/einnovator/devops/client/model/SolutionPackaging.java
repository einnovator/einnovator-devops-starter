package org.einnovator.devops.client.model;


public enum SolutionPackaging {
	MANIFEST("Manifest"),
	SPEC("Spec"),
	HELM("Helm");
	
	private final String displayValue;

	SolutionPackaging(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static SolutionPackaging parse(String s) {
		for (SolutionPackaging e: SolutionPackaging.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static SolutionPackaging parse(String s, SolutionPackaging defaultValue) {
		SolutionPackaging value = parse(s);
		return value!=null ? value: defaultValue;
	}

	public boolean isAutoStart() {
		switch (this) {
		case HELM:
			return true;
		case MANIFEST:
		case SPEC:
		default:
			return false;
		}
	}
	

}
