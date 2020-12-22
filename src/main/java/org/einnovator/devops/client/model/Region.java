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
	US_NORTH("us-north", "usa"),
	US_SOUTH("us-south", "usa"),
	
	EU_CENTRAL("eu-central", "eu"),
	EU_CENTRAL_DE("eu-central-de", "de"),
	EU_CENTRAL_NL("eu-central-nl", "nl"),
	EU_WEST("eu-west", "eu"),
	EU_EAST("eu-east", "eu"),

	EU_SOUTH("eu-south", "eu"),
	EU_NORTH("eu-north", "eu"),
	UK("uk", "uk"),
	
	MIDDLE_EAST("middle-east", "uk"),

	ASIA("asia", "k8s"),
	CHINA("china", "cn"),
	JAPAN("japan", "jp"),
	INDIA("india", "in"),
	ASIA_SG("asia-sg", "sg"),
	
	SAM("south-america", "k8s"),
		
	CANADA("canada", "ca"),
	
	AUSTRALIA("australia", "au"),
	
	AFRICA("africa", "k8s"),
	AF_SOUTH("africa-south", "k8s"),

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
