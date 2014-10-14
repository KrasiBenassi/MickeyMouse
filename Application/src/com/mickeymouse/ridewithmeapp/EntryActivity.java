package com.mickeymouse.ridewithmeapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mickeymouse.ridewithmeapp.Tasks.LoginRequestResultCallbackAction;
import com.telerik.everlive.sdk.core.EverliveApp;

public class EntryActivity extends Activity implements View.OnClickListener {

	private EverliveApp myApp = new EverliveApp("JXf8myCowKXQg50U");
    private Button login;
    private EditText user;
    private EditText pass;
    private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		login = (Button) findViewById(R.id.btnSingIn);
		user = (EditText) findViewById(R.id.etUserName);
		pass = (EditText) findViewById(R.id.etPass);
		progress = new ProgressDialog(this);
		login.setOnClickListener(this);
	}
	
    @Override
	public void onClick(View v) {
        this.progress.setMessage(this.getResources().getString(R.string.progress_login));
        this.progress.show();
        
		String username = user.getText().toString();
		String password = pass.getText().toString();
		
		myApp.workWith().authentication().login(username, password).executeAsync(new LoginRequestResultCallbackAction(this, this.progress));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entry, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent register = new Intent("com.mickeymouse.ridewithmeapp.REGISTERACTIVITY");
			startActivity(register);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
