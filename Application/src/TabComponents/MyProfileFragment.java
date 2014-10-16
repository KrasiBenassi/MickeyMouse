package TabComponents;

import com.mickeymouse.ridewithmeapp.Activities.MainPageActivity;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.telerik.everlive.sdk.core.model.system.User;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.mickeymouse.ridewithmeapp.R;

public class MyProfileFragment extends Fragment {

	private ImageView imgFavorite;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				com.mickeymouse.ridewithmeapp.R.layout.activity_profile,
				container, false);
		imgFavorite = (ImageView) view.findViewById(R.id.imageView1);
		User me = LoggedUser.getInstance().getLoggedUser();
		String emailString = me.getEmail();
		String userString = me.getUsername();
		TextView email = (TextView) view.findViewById(R.id.profEmail);
		TextView user = (TextView) view.findViewById(R.id.profName);
		email.setText(emailString);
		user.setText(userString);
		//Intent intent = new Intent(getActivity(), ProfileActivity.class);
		//startActivity(intent);
		
		imgFavorite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				open();
			}
		});
	

		return view;

	}
	
	private void open() {
		Intent intent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		this.startActivityForResult(intent, 0);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bp = (Bitmap) data.getExtras().get("data");
		imgFavorite.setImageBitmap(bp);

	}
}
