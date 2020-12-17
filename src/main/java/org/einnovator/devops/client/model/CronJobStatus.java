package org.einnovator.devops.client.model;


public enum CronJobStatus {
	CREATED("Created"),
	STARTING("Starting"),
	ACTIVE("Active"),
	SUSPENDED("Suspended"),
	SCHEDULED("Scheduled"),
	SHUTTING_DOWN("Shutting Down"),
	STOPPED("Stopped"),
	ERROR("Error");
	
	private final String displayValue;

	CronJobStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public String getDisplayName() {
		return displayValue;
	}
	public static CronJobStatus parse(String s) {
		for (CronJobStatus e: CronJobStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static CronJobStatus parse(String s, CronJobStatus defaultValue) {
		CronJobStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
