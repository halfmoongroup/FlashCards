package com.hmg.app.flash.util;

import javax.inject.Inject;

import lombok.Data;

@Data
public class AppInfo {

    private final String appUserId;

    
    @Inject
    public AppInfo(String appUser) {
    	appUserId = appUser;
    }
}
