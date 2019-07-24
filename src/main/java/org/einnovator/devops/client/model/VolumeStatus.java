package org.einnovator.devops.client.model;


public enum VolumeStatus {
	BOUND("Bound"),
	RELEASED("Released");
	
	private final String displayName;

	VolumeStatus(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static VolumeStatus parse(String s) {
		for (VolumeStatus e: VolumeStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static VolumeStatus parse(String s, VolumeStatus defaultValue) {
		VolumeStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
