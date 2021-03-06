package org.einnovator.devops.client.model;


public enum JobStatus {
	CREATED("Created"),
	STARTING("Starting"),
	RUNNING("Running"),
	COMPLETED("Completed"),
	SHUTTING_DOWN("Shutting Down"),
	STOPPED("Stopped"),
	ERROR("Error");
	
	private final String displayValue;

	JobStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public String getDisplayName() {
		return displayValue;
	}
	public static JobStatus parse(String s) {
		for (JobStatus e: JobStatus.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static JobStatus parse(String s, JobStatus defaultValue) {
		JobStatus value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
