package org.einnovator.devops.client.model;

public enum MountType {
	VOLUME("Volume"),
	SECRET("Secret"),
	CONFIGMAP("ConfigMap");
	
	private final String displayValue;

	MountType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	
	public static MountType parse(String s) {
		if (s!=null) {
			for (MountType e: MountType.class.getEnumConstants()) {
				if (e.toString().equalsIgnoreCase(s)) {
					return e;
				}
			}			
		}
		return null;
	}
	
	public static MountType parse(String s, MountType defaultValue) {
		MountType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}