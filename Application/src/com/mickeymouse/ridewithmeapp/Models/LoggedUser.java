package com.mickeymouse.ridewithmeapp.Models;

import java.util.ArrayList;
import java.util.List;

import com.telerik.everlive.sdk.core.model.system.User;

public class LoggedUser {

	private static LoggedUser instance;
	private User loggedUser;
	private List myTrips;
	private List tripsSignedFor;

    private LoggedUser() {
        this.myTrips = new ArrayList<Trip>();
        this.tripsSignedFor = new ArrayList<Trip>();
    }
    
    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }


    public static LoggedUser getInstance() {
        if (instance == null) {
            instance = new LoggedUser();
        }
        return instance;
    }
}
