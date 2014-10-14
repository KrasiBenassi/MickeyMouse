package com.mickeymouse.ridewithmeapp.Models;

import java.util.ArrayList;
import java.util.List;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

@ServerType("Trips")
public class Trip extends DataItem {

	@ServerProperty("From")
	private Town from;

	@ServerProperty("To")
	private Town to;

	@ServerProperty("Duration")
	private String duration;

	@ServerProperty("Distance")
	private Double distance;

	@ServerProperty("Host")
	private User host;

	@ServerProperty("IsSmokingAllowed")
	private boolean isSmokingAllowed;

	@ServerProperty("AreAnimalsAllowed")
	private boolean areAnimalsAllowed;

	@ServerProperty("UnoccupiedSeats")
	private int unoccupiedSeats;

	@ServerProperty("DestinationPoint")
	private String destinationPoint;

	@ServerProperty("DeparturePoint")
	private String departurePoint;

	@ServerProperty("SignedPeople ")
	private List<User> signedPeople;

	public Trip() {
		this.signedPeople = new ArrayList<User>();
	}

	public Town getDepartureTown() {
		return this.from;
	}

	public void setDepartureTown(Town town) {
		this.from = town;
	}

	public Town getDestinationTown() {
		return this.to;
	}

	public void setDestinationTown(Town town) {
		this.to = town;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getDistance() {
		return this.distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public User getHost() {
		return this.host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public boolean getSmokingStatus() {
		return this.isSmokingAllowed;
	}

	public void setSmokingStatus(Boolean isAllowed) {
		this.isSmokingAllowed = isAllowed;
	}

	public boolean getAnimalsStatus() {
		return this.areAnimalsAllowed;
	}

	public void setAnimalsStatus(Boolean areAllowed) {
		this.areAnimalsAllowed = areAllowed;
	}

	public int getUnoccupiedSeats() {
		return this.unoccupiedSeats;
	}

	public void setUnoccupiedSeats(int number) {
		this.unoccupiedSeats = number;
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

	public List<User> getSignedPeople() {
		return this.signedPeople;
	}

}
