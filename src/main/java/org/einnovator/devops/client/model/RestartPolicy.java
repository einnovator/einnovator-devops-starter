package org.einnovator.devops.client.model;


public enum RestartPolicy {
	ALWAYS("Always", false),
	ON_FAILURE("OnFailure", true),
	NEVER("Never", true);
	
	private final String displayValue;

	private final boolean jobs;

	RestartPolicy(String displayValue, boolean jobs) {
		this.displayValue = displayValue;
		this.jobs = jobs;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public String getDisplayName() {
		return displayValue;
	}

	/**
	 * Get the value of property {@code jobs}.
	 *
	 * @return the jobs
	 */
	public boolean isJobs() {
		return jobs;
	}

	public static RestartPolicy parse(String s) {
		for (RestartPolicy e: RestartPolicy.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static RestartPolicy parse(String s, RestartPolicy defaultValue) {
		RestartPolicy value = parse(s);
		return value!=null ? value: defaultValue;
	}


}
