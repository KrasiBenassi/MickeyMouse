package com.mickeymouse.ridewithmeapp.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.DbComponents.DbManager;
import com.mickeymouse.ridewithmeapp.Tasks.LoginRequestResultCallbackAction;
import com.telerik.everlive.sdk.core.EverliveApp;

public class EntryActivity extends Activity implements View.OnClickListener {

	private Button login;
	private EditText user;
	private EditText pass;
	private ProgressDialog progress;
	private Button signUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		signUp = (Button) findViewById(R.id.btnSingUp);
		login = (Button) findViewById(R.id.btnSingIn);
		user = (EditText) findViewById(R.id.etUserName);
		pass = (EditText) findViewById(R.id.etPass);
		progress = new ProgressDialog(this);
		login.setOnClickListener(this);
		signUp.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnSingIn: {
			this.progress.setMessage(this.getResources().getString(
					R.string.progress_login));
			this.progress.show();

			String username = user.getText().toString();
			String password = pass.getText().toString();

			DbManager manager = DbManager.GetInstance();
			manager.SetDb();
			manager.GetDb()
					.workWith()
					.authentication()
					.login(username, password)
					.executeAsync(
							new LoginRequestResultCallbackAction(this,
									this.progress));
			break;
		}
		case R.id.btnSingUp: {
			Intent register = new Intent(
					"com.mickeymouse.ridewithmeapp.REGISTERACTIVITY");
			startActivity(register);
			break;
		}
		}

	}
/*
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
			Intent register = new Intent(
					"com.mickeymouse.ridewithmeapp.REGISTERACTIVITY");
			startActivity(register);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	*/
}
