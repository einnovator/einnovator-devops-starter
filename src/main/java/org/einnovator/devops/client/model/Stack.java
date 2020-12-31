package org.einnovator.devops.client.model;


public enum Stack {
	SUITE_BOOT("Suite/Spring Boot", new String[]{"suite/spring", "suite/boot"}),
	SPRING_BOOT("Spring Boot", new String[]{"spring", "boot"}),
	SUITE_JAVA("Suite/Java"),
	JAVA("Java"),
	PHP("Php"),
	GO("Go"),
	NODE("Node"),
	CSHARP("C#", new String[]{"csharp"}),
	SUITE_BACKEND("Suite"),
	BACKEND("BackEnd"),
	FRONTEND("FrontEnd"),
	STATIC("Static"),
	OTHER("Other")
	;

	
	private final String displayValue;
	private final String[] alias;

	Stack(String displayValue) {
		this(displayValue, null);
	}

	Stack(String displayValue, String[] alias) {
		this.displayValue = displayValue;
		this.alias = alias;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static Stack parse(String s) {
		for (Stack e: Stack.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s) ||
				e.toString().replaceAll("_", "").equalsIgnoreCase(s) ||
				e.toString().replaceAll("_", "-").equalsIgnoreCase(s)) {
				return e;
			}
			if (e.alias!=null) {
				for (String alias: e.alias) {
					if (alias.equalsIgnoreCase(s)) {
							return e;
						}
				}
			}
		}
		return null;
	}
	
	public static Stack parse(String s, Stack defaultValue) {
		Stack value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
