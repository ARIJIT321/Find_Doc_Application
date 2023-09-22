package com.doc.enums;

public enum Ent {

	Ear("Ear Pain");
	
	private final String displayName;

	Ent(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
