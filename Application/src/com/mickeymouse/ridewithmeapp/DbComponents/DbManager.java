package com.mickeymouse.ridewithmeapp.DbComponents;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.model.system.User;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

public class DbManager {

	private EverliveApp db;
	private static DbManager manager;

	private DbManager() {
	}

	public static DbManager GetInstance() {
		if (manager == null) {
			manager = new DbManager();
		}

		return manager;
	}

	public void SetDb() {
		this.db = new EverliveApp("JXf8myCowKXQg50U");
	}

	public EverliveApp GetDb() {
		return db;
	}

	public void GetLoggedUser() {
		RequestResult<User> user = db.workWith().users().getMe().executeSync();
		User me = user.getValue();
	}
	
}
