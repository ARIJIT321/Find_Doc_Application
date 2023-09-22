package com.doc.enums;

public enum Dermatology {
	Skin(""),
	Infection("Skin Infection"),
	Burn("Skin Burn");
	
	private final String displayName;

	Dermatology(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
