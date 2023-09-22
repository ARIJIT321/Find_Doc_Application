package com.doc.enums;

public enum Orthopedic {

	ARTHRITIS("arthritis"),
	BACK("Back Pain"),
	Tissue("Tissue injuries");

	private final String displayName;

	Orthopedic(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
	
	
}
