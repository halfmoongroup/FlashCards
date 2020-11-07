package com.hmg.app.flash.api.util;

import org.apache.cayenne.ExtendedEnumeration;

public enum DeckVisibility implements ExtendedEnumeration {


	PUBLIC("public"),
	PRIVATE("private");
	
    private String value;
	
    private DeckVisibility(String value) {
        this.value = value;
    }
    
	@Override
	public Object getDatabaseValue() {
		return value;
	}

}


