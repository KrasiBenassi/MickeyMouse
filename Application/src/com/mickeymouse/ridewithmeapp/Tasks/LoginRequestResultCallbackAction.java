package com.mickeymouse.ridewithmeapp.Tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.Activities.MainPageActivity;
import com.mickeymouse.ridewithmeapp.DbComponents.DbManager;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.telerik.everlive.sdk.core.model.system.AccessToken;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

public class LoginRequestResultCallbackAction extends
		RequestResultCallbackAction<AccessToken> {

	private Activity activity;
	private ProgressDialog progress;

	public LoginRequestResultCallbackAction(Activity activity,
			ProgressDialog progress) {
		this.activity = activity;
		this.progress = progress;
	}

	@Override
	public void invoke(RequestResult<AccessToken> accessTokenRequestResult) {

		if (accessTokenRequestResult.getSuccess()) {
			progress.dismiss();
			RequestResult<User> user = DbManager.GetInstance().GetDb().workWith().users().getMe().executeSync();
			User me = user.getValue();
			LoggedUser.getInstance().setLoggedUser(me);
			User user2 = LoggedUser.getInstance().getLoggedUser();
			
			this.activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					
					Intent intent = new Intent(activity, MainPageActivity.class);
					activity.startActivity(intent);
				}
			});

		} else {
			progress.dismiss();
			this.activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(activity, R.string.login_error,
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}

}
