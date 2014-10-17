package com.mickeymouse.ridewithmeapp.Activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mickeymouse.ridewithmeapp.DbComponents.DbManager;
import com.mickeymouse.ridewithmeapp.Models.Trip;
import com.telerik.everlive.sdk.core.query.definition.filtering.simple.ValueCondition;
import com.telerik.everlive.sdk.core.query.definition.filtering.simple.ValueConditionOperator;
import com.telerik.everlive.sdk.core.result.RequestResult;

public class JoinedTripsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String fromTown = intent.getStringExtra("from");
		String toTown = intent.getStringExtra("to");
		ArrayList<Trip> trips = GetContent();

		/*
		 * RequestResult<ArrayList<Trip>> booksFromAuthorResult =
		 * DbManager.GetInstance().GetDb().workWith().data(Trip.class) .get()
		 * .where(new ValueCondition("From", fromTown,
		 * ValueConditionOperator.EqualTo) .where(new ValueCondition("To",
		 * toTown, ValueConditionOperator.EqualTo) .executeSync();
		 */

	}

	private ArrayList<Trip> GetContent() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip = new Trip();
		trip.setDeparturePoint("София");
		trip.setDestinationPoint("Пловдив");
		trip.setDate("14.10.2014");
		trip.setTime("14:00");
		trips.add(trip);
		return trips;

	}
}
