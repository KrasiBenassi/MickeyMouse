package com.mickeymouse.ridewithmeapp.Utils;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.Models.Trip;

public class TripArrayAdapter extends ArrayAdapter<Trip> {

	private Context context;
	private int layoutId;
	private List<Trip> trips;

	public TripArrayAdapter(Context context, int resource, List<Trip> objects) {
		super(context, resource, objects);
		this.context = context;
		this.layoutId = resource;
		this.trips = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		View rowView = inflater.inflate(this.layoutId, parent);
		TextView destination = (TextView) rowView.findViewById(R.id.list_item_destination);
		destination.setText(trips.get(position).getDepartureTown() + " - " + trips.get(position).getDestinationTown());
		TextView date = (TextView) rowView.findViewById(R.id.list_item_date);
		date.setText(trips.get(position).getDate() + " - " + trips.get(position).getTime() + " часа");
		return rowView;
	}

}
