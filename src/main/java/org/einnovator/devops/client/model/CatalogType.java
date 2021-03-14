package org.einnovator.devops.client.model;


public enum CatalogType {
	HELM("Helm"),
	NATIVE("Native");
	
	private final String displayValue;

	CatalogType(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
	public static CatalogType parse(String s) {
		for (CatalogType e: CatalogType.class.getEnumConstants()) {
			if (e.toString().equalsIgnoreCase(s)) {
				return e;
			}
		}
		return null;
	}
	
	public static CatalogType parse(String s, CatalogType defaultValue) {
		CatalogType value = parse(s);
		return value!=null ? value: defaultValue;
	}
	

}
