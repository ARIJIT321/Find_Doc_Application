package com.doc.enums;

public enum Gynecology {

	Dysmenorrhea("");
	
	private final String displayName;

	Gynecology(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
