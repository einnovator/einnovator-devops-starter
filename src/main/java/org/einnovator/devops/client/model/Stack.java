package org.einnovator.devops.client.model;


public enum Stack {
	SUITE_BOOT("EInnovator Suite/Spring Boot"),
	SPRING_BOOT("Spring Boot"),
	JAVA("Java BackEnd"),
	BACKEND("Generic BackEnd"),
	FRONTEND("Pure Front-End"),
	STATIC("Static"),
	OTHER("Other")
	;

	
	private final String displayValue;

	Stack(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static Stack parse(String s) {
		for (Stack e: Stack.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static Stack parse(String s, Stack defaultValue) {
		Stack value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
