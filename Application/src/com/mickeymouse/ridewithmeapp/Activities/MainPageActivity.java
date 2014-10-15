package com.mickeymouse.ridewithmeapp.Activities;

import TabComponents.MyProfileFragment;
import TabComponents.SignedForFragment;
import TabComponents.TabListener;
import TabComponents.myTripsFragment;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.mickeymouse.ridewithmeapp.R;

public class MainPageActivity extends Activity {

	private ActionBar.Tab myTripsTab;
	private ActionBar.Tab signedForTab;
	private ActionBar.Tab profileTab;
	
	//fix with concrete classes for Fragment
	Fragment mytripsFragment = new myTripsFragment();
	Fragment signedForFragment = new SignedForFragment();
	Fragment profileTabFragment = new MyProfileFragment();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        setContentView(R.layout.activity_main_page);
        
        myTripsTab = actionBar.newTab().setText(R.string.tab_mytrips);
        signedForTab = actionBar.newTab().setText(R.string.tab_signedFor);
        profileTab = actionBar.newTab().setText(R.string.tab_profile);
        
        myTripsTab.setTabListener(new TabListener(mytripsFragment));
        signedForTab.setTabListener(new TabListener(signedForFragment));
        profileTab.setTabListener(new TabListener(profileTabFragment));
        
        actionBar.addTab(myTripsTab);
        actionBar.addTab(signedForTab);
        actionBar.addTab(profileTab);
	}

}
