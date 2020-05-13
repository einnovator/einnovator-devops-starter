/**
 * 
 */
package org.einnovator.devops.client.model;

/**
 * A {@code Region}.
 *
 */
public enum Region {
	US_EAST("us-east", "usa"),
	US_WEST("us-west", "usa"),
	US_CENTRAL("us-central", "usa"),
	EU_CENTRAL("eu-central", "eu"),
	EU_CENTRAL_DE("eu-central-de", "de"),
	EU_CENTRAL_NL("eu-central-nl", "nl"),
	UK("uk", "uk"),
	ASIA("asia", "k8s"),
	CHINA("china", "cn"),
	JAPAN("japan", "jp"),
	INDIA("india", "in"),
	SAM("south-america", "k8s"),
	AUSTRALIA("australia", "au"),
	ASIA_SG("asia-sg", "sg"),
	AFRICA("africa", "k8s"),
	OTHER("other", "k8s")
	;
	    	
	private final String displayValue;

	private final String icon;

	Region(String displayValue, String icon) {
		this.displayValue = displayValue;
		this.icon = icon;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public String getIcon() {
		return icon;
	}

	public String getFlag() {
		return icon;
	}
	
	public static Region parse(String s) {
		if (s!=null) {
			for (Region e: Region.class.getEnumConstants()) {
				if (e.toString().equalsIgnoreCase(s)) {
					return e;
				}
			}			
		}
		return null;
	}
	
	public static Region parse(String s, Region defaultValue) {
		Region value = parse(s);
		return value!=null ? value: defaultValue;
	}
}
