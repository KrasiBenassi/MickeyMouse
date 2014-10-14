package com.mickeymouse.ridewithmeapp.Tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.mickeymouse.ridewithmeapp.EntryActivity;
import com.mickeymouse.ridewithmeapp.RegisterActivity;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.model.system.AccessToken;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

public class LoginRequestResultCallbackAction extends RequestResultCallbackAction<AccessToken>{

	private Activity activity;
	private ProgressDialog progress;
	private EverliveApp app = new EverliveApp("JXf8myCowKXQg50U");
	
	public LoginRequestResultCallbackAction(Activity activity, ProgressDialog progress){
		this.activity = activity;
		this.progress = progress;
	}
	
	@Override
    public void invoke(RequestResult<AccessToken> accessTokenRequestResult) {


        if (accessTokenRequestResult.getSuccess()) {

             app.workWith().users().getMe().executeAsync(new RequestResultCallbackAction() {
                @Override
                public void invoke(RequestResult requestResult) {
                    User me = (User) requestResult.getValue();
                    LoggedUser.getInstance().setLoggedUser(me);

                    progress.dismiss();

                    // create activity after login !! Remove that later! 
                    Intent intent = new Intent(activity, RegisterActivity.class);
                    activity.startActivity(intent);
                }
            });
        } else {
            progress.dismiss();

            final String errorMessage = accessTokenRequestResult.getError().getMessage();

            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                	 Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT);
                }
            });
        }
	}
	
}
