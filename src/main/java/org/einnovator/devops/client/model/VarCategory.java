package org.einnovator.devops.client.model;


public enum VarCategory {
	VALUE("Value"),
	CONFIGMAP("ConfigMap"),
	SECRET("Secret"),
	FIELD("Field"),
	RESOURCE("Resource"),
	;
	
	private final String displayValue;

	VarCategory(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static VarCategory parse(String s) {
		for (VarCategory e: VarCategory.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static VarCategory parse(String s, VarCategory defaultValue) {
		VarCategory value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
