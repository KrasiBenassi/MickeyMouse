package com.mickeymouse.ridewithmeapp.Models;

import java.util.ArrayList;
import java.util.List;

import android.R.string;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Trips")
public class Trip extends DataItem {

	@ServerProperty("Date")
	private String date;

	@ServerProperty("Time")
	private String time;

	@ServerProperty("TotalSeats")
	private int totalSeats;

	@ServerProperty("Host")
	private String host;

	@ServerProperty("To")
	private String destinationPoint;

	@ServerProperty("From")
	private String departurePoint;

	@ServerProperty("SignedPeople")
	private List<String> signedPeople;

	public void setTotalSeats(int number) {
		this.totalSeats = number;
	}

	public int getTotalSeats() {
		return this.totalSeats;
	}

	public Trip() {
		this.signedPeople = new ArrayList<String>();
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDeparturePoint() {
		return this.departurePoint;
	}

	public void setDeparturePoint(String departure) {
		this.departurePoint = departure;
	}

	public String getDestinationPoint() {
		return this.destinationPoint;
	}

	public void setDestinationPoint(String destination) {
		this.destinationPoint = destination;
	}

	public List<String> getSignedPeople() {
		return this.signedPeople;
	}

}
