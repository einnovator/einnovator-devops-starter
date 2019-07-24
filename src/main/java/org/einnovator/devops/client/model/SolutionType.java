package org.einnovator.devops.client.model;


public enum SolutionType {
	APPLICATION("Application"),
	SERVICE("Service"),
	SUITE("Suite"),
	DATABASE("Database"),
	MSGBROKER("Message Broker"),
	DEVTOOL("Dev Tool");
	
	private final String displayValue;

	SolutionType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static SolutionType parse(String s) {
		for (SolutionType e: SolutionType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static SolutionType parse(String s, SolutionType defaultValue) {
		SolutionType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
