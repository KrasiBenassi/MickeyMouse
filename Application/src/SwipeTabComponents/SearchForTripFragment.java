package SwipeTabComponents;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.Activities.SearchedListActivity;

public class SearchForTripFragment extends Fragment {
	
	private EditText from;
	private EditText to;
	private Button search;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_search_for_trips, container,
				false);
		
		from = (EditText) view.findViewById(R.id.search_from);
		to = (EditText) view.findViewById(R.id.search_to);
		search = (Button) view.findViewById(R.id.search);
		
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), SearchedListActivity.class);
				intent.putExtra("from", from.getText().toString());
				intent.putExtra("to", to.getText().toString());
			//	startActivity(intent);
			}
		});
		return view;
	}
	
}
