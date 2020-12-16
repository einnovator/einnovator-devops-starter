package org.einnovator.devops.client.model;


public enum ProviderType {
	ONPREMISE("OnPremise"),
	EINNOVATOR("EInnovator"),
	AWS("AWS"),
	GOOGLE("Google"),
	AZURE("Azure"),
	IBM("IBM"),
	DO("DigitalOcean"),
	LINODE("Linode"),
	SCALEWAY("Scaleway"),
	OTHER("Other"),
	;
	
	private final String displayValue;

	ProviderType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static ProviderType parse(String s) {
		for (ProviderType e: ProviderType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static ProviderType parse(String s, ProviderType defaultValue) {
		ProviderType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
