package org.einnovator.devops.client.model;

public enum EventType {
	STARTED("Started"),
	STOPPED("Stopped"),
	CRASHED("Crashed"),
	RESTARTED("Restarted"),
	SCALED_REPLICAS("Scaled Replicas"),
	SCALED_RESOURCES("Scaled Resources")
	;
	
	private final String displayValue;

	EventType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	
	public static EventType parse(String s) {
		if (s!=null) {
			for (EventType e: EventType.class.getEnumConstants()) {
				if (e.toString().equalsIgnoreCase(s)) {
					return e;
				}
			}			
		}
		return null;
	}
	
	public static EventType parse(String s, EventType defaultValue) {
		EventType value = parse(s);
		return value!=null ? value: defaultValue;
	}

}