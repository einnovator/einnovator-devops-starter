package org.einnovator.devops.client.model;


public enum Stack {
	SUITE_BOOT("Suite/Spring Boot", new String[]{"suite/spring", "suite/boot"}),
	SUITE_JAVA("Suite/Java"),
	SUITE_BACKEND("Suite"),

	SPRING_BOOT("Spring Boot", new String[]{"spring", "boot"}),
	QUARKUS("Quarkus"),
	MICRONAUT("Micronaut"),
	HELIDON("Helidon"),
	JAVA("Java"),
	PHP("Php"),
	GO("Go"),
	NODEJS("NodeJS", new String[]{"node"}),
	PYTHON("Python"), 
	RUBY("Ruby"),
	RUST("Rust"),
	VERTX("Vertx"), 
	CSHARP("C#", new String[]{"csharp"}),
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
