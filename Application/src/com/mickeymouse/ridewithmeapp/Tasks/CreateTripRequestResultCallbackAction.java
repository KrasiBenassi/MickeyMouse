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

public class CreateTripRequestResultCallbackAction extends
RequestResultCallbackAction<AccessToken> {

	private Activity activity;

	public CreateTripRequestResultCallbackAction(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void invoke(RequestResult<AccessToken> accessTokenRequestResult) {

		if (accessTokenRequestResult.getSuccess()) {
			this.activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					
					Toast.makeText(activity, "Маршрутът е създаден!", Toast.LENGTH_SHORT).show();
				}
			});

		} else {
			this.activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(activity, "Грешка при създаване!",
							Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
