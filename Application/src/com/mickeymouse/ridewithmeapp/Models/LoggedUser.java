package com.mickeymouse.ridewithmeapp.Models;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

import com.telerik.everlive.sdk.core.model.system.User;

public class LoggedUser {

	private static LoggedUser instance;
	private static User loggedUser;
	private List myTrips;
	private List tripsSignedFor;
	private Bitmap photo;

	private LoggedUser() {
		this.myTrips = new ArrayList<Trip>();
		this.tripsSignedFor = new ArrayList<Trip>();
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public User getLoggedUser() {
		return this.loggedUser;
	}
	
	public void setPhoto(Bitmap ph){
		this.photo = ph;
	}
	
	public Bitmap getPhoto(){
		return this.photo;
	}

	public static LoggedUser getInstance() {
		if (instance == null) {
			instance = new LoggedUser();
		}
		return instance;
	}
}
