package org.einnovator.devops.client.model;


public enum ImageType {
	DOCKER("Docker"),
	WAR("War");
	
	private final String displayName;

	ImageType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public static ImageType parse(String s) {
		for (ImageType e: ImageType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ImageType parse(String s, ImageType defaultValue) {
		ImageType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
