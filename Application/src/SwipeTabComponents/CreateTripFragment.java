package SwipeTabComponents;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.DbComponents.DbManager;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.mickeymouse.ridewithmeapp.Models.Trip;
import com.mickeymouse.ridewithmeapp.Tasks.CreateTripRequestResultCallbackAction;

import LocalStorage.LocalDb;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateTripFragment extends Fragment {

	private Button create;
	private EditText from;
	private EditText to;
	private EditText time;
	private EditText date;
	private LocalDb dbMytrips;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_make_trip,
				container, false);
		
		dbMytrips = new LocalDb(getActivity().getApplicationContext(), "Trips", "myTrips");
		create = (Button) view.findViewById(R.id.makeBtn);
		from = (EditText) view.findViewById(R.id.etMakeFrom);
		to = (EditText) view.findViewById(R.id.etMakeTo);
		date = (EditText) view.findViewById(R.id.etMakeDate);
		time = (EditText) view.findViewById(R.id.etMakeTime);
		
		create.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String fromString = from.getText().toString();
				String toString = to.getText().toString();
				String dateString = date.getText().toString();
				String timeString = time.getText().toString();
				Trip tripInfo = new Trip();
				tripInfo.setDeparturePoint(fromString);
				tripInfo.setDestinationPoint(toString);
				tripInfo.setDate(dateString);
				tripInfo.setTime(timeString);
				tripInfo.setHost(LoggedUser.getInstance().getLoggedUser().getUsername());
				tripInfo.setTotalSeats(4);
				dbMytrips.addTrip(tripInfo);
				DbManager.GetInstance().GetDb().workWith().data(Trip.class).create(tripInfo)
				.executeAsync(new CreateTripRequestResultCallbackAction(getActivity()));
				from.setText(" ");
				to.setText(" ");
				date.setText(" ");
				time.setText(" ");
			}
		});
		return view;
	} 
	
}
