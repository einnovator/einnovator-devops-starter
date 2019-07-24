/**
 * 
 */
package org.einnovator.devops.client.model;

/**
 * A {@code ContentType}.
 *
 */
public enum ContentType {
	HTML("Html", "icon-html-five2"),
	TEXT("Text", "icon-file-text2"),
	PDF("PDF", "icon-file-pdf"),
	IMAGE("Image", "icon-file-picture"),
	VIDEO("Video", " icon-file-play"),
	AUDIO("Audio", "icon-file-music");
	
	private final String displayName;

	private final String icon;

	ContentType(String displayName, String icon) {
		this.displayName = displayName;
		this.icon = icon;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDisplayValue() {
		return displayName;
	}

	public String getIcon() {
		return icon;
	}

	
	public static ContentType parse(String s) {
		if (s!=null) {
			for (ContentType e: ContentType.class.getEnumConstants()) {
				if (e.toString().equalsIgnoreCase(s)) {
					return e;
				}
			}			
		}
		return null;
	}
	
	public static ContentType parse(String s, ContentType defaultValue) {
		ContentType value = parse(s);
		return value!=null ? value: defaultValue;
	}
}
