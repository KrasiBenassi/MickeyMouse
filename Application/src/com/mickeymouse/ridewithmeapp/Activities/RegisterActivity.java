package com.mickeymouse.ridewithmeapp.Activities;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.R.layout;
import com.mickeymouse.ridewithmeapp.Tasks.RegisterRequestResultCallbackAction;
import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.query.definition.UserSecretInfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity implements OnClickListener {

	private Button register;
	private EditText username;
	private EditText password;
	private EditText email;
	private EditText confirmPassword;
	private ProgressDialog progress;
	private EverliveApp app = new EverliveApp("JXf8myCowKXQg50U");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		register = (Button) findViewById(R.id.regBtn);
		username = (EditText) findViewById(R.id.etRegUserName);
		password = (EditText) findViewById(R.id.etRegPass);
		email = (EditText) findViewById(R.id.etRegEmail);
		confirmPassword = (EditText) findViewById(R.id.etRegConfPass);
		progress = new ProgressDialog(this);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		String passwordString = password.getText().toString().trim();
		String usernameString = username.getText().toString().trim();
		String confirmPass = confirmPassword.getText().toString().trim();
		String emailString = email.getText().toString().trim();

		if (usernameString.equals("") || passwordString.equals("")) {

			Toast.makeText(this, "Невалидни данни!", Toast.LENGTH_SHORT);
		}

		if (passwordString != confirmPass) {
			Toast.makeText(this, "Въвели сте различни пароли!",
					Toast.LENGTH_SHORT);
		}

		this.progress.setMessage(this.getResources().getString(
				R.string.progress_register));
		this.progress.show();

		final User user = new User();
		user.setUsername(usernameString);
		user.setDisplayName(usernameString);
		user.setEmail(emailString);
		UserSecretInfo info = new UserSecretInfo();
		info.setPassword(passwordString);
		app.workWith().users().create(user, info).executeAsync(new RegisterRequestResultCallbackAction(this, this.progress));

	}

}
