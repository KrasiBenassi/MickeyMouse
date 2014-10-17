package com.mickeymouse.ridewithmeapp.Activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.Models.Trip;
import com.mickeymouse.ridewithmeapp.Utils.TripArrayAdapter;

public class SearchedListActivity extends Activity {

	private Button btn;
	private ListView lw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);
		lw = (ListView) findViewById(R.id.listView1);
		ArrayList<Trip> trips = new ArrayList<Trip>();
		Trip trip = new Trip();
		trip.setDestinationPoint("София");
		trip.setDeparturePoint("Плевен");
		trip.setDate("12.05.2012");
		trip.setTime("05.10.2012");
		trips.add(trip);
			TripArrayAdapter adapter = new TripArrayAdapter(this, R.layout.list_item, trips);
			lw.setAdapter(adapter);
	}

}
