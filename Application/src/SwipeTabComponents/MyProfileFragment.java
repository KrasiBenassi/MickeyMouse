package SwipeTabComponents;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.DbComponents.DbManager;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.query.definition.FileField;

public class MyProfileFragment extends Fragment {

	private ImageView imgFavorite;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(
				com.mickeymouse.ridewithmeapp.R.layout.activity_profile,
				container, false);
		imgFavorite = (ImageView) view.findViewById(R.id.imageView1);
		Bitmap photo = LoggedUser.getInstance().getPhoto();
		if (photo != null) {
			imgFavorite.setImageBitmap(photo);
		}

		User me = LoggedUser.getInstance().getLoggedUser();
		String emailString = me.getEmail();
		String userString = me.getUsername();
		TextView email = (TextView) view.findViewById(R.id.profEmail);
		TextView user = (TextView) view.findViewById(R.id.profName);
		email.setText("E-mail:  " + emailString);
		user.setText("Username:  " + userString);

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
		this.startActivityForResult(intent, 1);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == -1) {
			Bitmap bp = (Bitmap) data.getExtras().get("data");
			ByteArrayOutputStream pic = new ByteArrayOutputStream();
			bp.compress(CompressFormat.PNG, 0 /* ignored for PNG */, pic);
			byte[] bitmapdata = pic.toByteArray();
			ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);
			String username = LoggedUser.getInstance().getLoggedUser()
					.getUsername();
			FileField fileField = new FileField(username, "image", bs);
			DbManager.GetInstance().GetDb().workWith().files()
					.upload(fileField).executeSync();
			LoggedUser.getInstance().setPhoto(bp);
			imgFavorite.setImageBitmap(bp);
		}
	}
}
