package com.mickeymouse.ridewithmeapp.Tasks;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.mickeymouse.ridewithmeapp.Activities.EntryActivity;
import com.mickeymouse.ridewithmeapp.Activities.RegisterActivity;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

public class RegisterRequestResultCallbackAction extends RequestResultCallbackAction {
    private Activity activity;
    private ProgressDialog progressDialog;

    public RegisterRequestResultCallbackAction(RegisterActivity registerActivity, ProgressDialog registerProgressDialog) {
        this.activity = registerActivity;
        this.progressDialog = registerProgressDialog;
    }

    @Override
    public void invoke(RequestResult requestResult) {
        this.progressDialog.dismiss();

        if (requestResult.getSuccess()) {

            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                	Intent intent = new Intent(activity, EntryActivity.class);
                   Toast.makeText(activity, activity.getResources().getString(com.mickeymouse.ridewithmeapp.R.string.register_onsucceed), Toast.LENGTH_LONG).show();
                   activity.startActivity(intent);
                }
            });
        } else {
            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                	Toast.makeText(activity, com.mickeymouse.ridewithmeapp.R.string.register_error , Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
