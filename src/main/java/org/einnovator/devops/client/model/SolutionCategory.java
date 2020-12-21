package org.einnovator.devops.client.model;


public enum SolutionCategory {
	APPLICATION("Application"),
	SERVICE("Service"),
	WEBSERVER("WebServer"),
	DATABASE("Database"),
	MSGBROKER("Message Broker"),
	TOOL("Tool"),
	JOB("Job"),
	CRONJOB("CronJob"),
	PIPELINE("Pipeline"),
	TASK("Task"),
	CLUSTER_TASK("ClusterTask"),
	SUITE("Suite"),
	OTHER("Other"),
	;
	
	private final String displayValue;

	SolutionCategory(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	public static SolutionCategory parse(String s) {
		for (SolutionCategory e: SolutionCategory.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static SolutionCategory parse(String s, SolutionCategory defaultValue) {
		SolutionCategory value = parse(s);
		return value!=null ? value: defaultValue;
	}

}
