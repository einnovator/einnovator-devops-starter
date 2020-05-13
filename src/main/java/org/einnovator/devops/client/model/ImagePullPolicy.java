package org.einnovator.devops.client.model;


public enum ImagePullPolicy {
	ALWAYS("Always"),
	IFNOTPRESENT("IfNotPresent"),
	NEVER("Never");

	private final String displayValue;

	ImagePullPolicy(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static ImagePullPolicy parse(String s) {
		for (ImagePullPolicy e: ImagePullPolicy.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s) || e.getDisplayName().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ImagePullPolicy parse(String s, ImagePullPolicy defaultValue) {
		ImagePullPolicy value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
