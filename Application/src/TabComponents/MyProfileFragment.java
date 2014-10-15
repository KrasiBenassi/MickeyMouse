package TabComponents;

import com.mickeymouse.ridewithmeapp.Activities.MainPageActivity;
import com.mickeymouse.ridewithmeapp.Activities.ProfileActivity;

import android.R;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyProfileFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(com.mickeymouse.ridewithmeapp.R.layout.activity_profile, container, false);
		return view;
	}
}
