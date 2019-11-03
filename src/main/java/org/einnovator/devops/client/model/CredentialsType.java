package org.einnovator.devops.client.model;


public enum CredentialsType {
	USERNAME_PASSWORD("Username/Password"),
	OAUTH2_TOKEN("OAuth2 Token"),
	SSH_KEY("SSH Private Key"),
	JSON_KEY("Json Key");
	
	private final String displayValue;

	CredentialsType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static CredentialsType parse(String s) {
		for (CredentialsType e: CredentialsType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static CredentialsType parse(String s, CredentialsType defaultValue) {
		CredentialsType value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
