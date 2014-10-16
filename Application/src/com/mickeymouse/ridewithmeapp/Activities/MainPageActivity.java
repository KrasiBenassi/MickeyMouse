package com.mickeymouse.ridewithmeapp.Activities;

import TabComponents.CreateTripFragment;
import TabComponents.MyProfileFragment;
import TabComponents.SearchForTripFragment;
import TabComponents.TabListener;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.mickeymouse.ridewithmeapp.R;
import com.mickeymouse.ridewithmeapp.Models.LoggedUser;
import com.telerik.everlive.sdk.core.model.system.User;

public class MainPageActivity extends Activity {

	private ActionBar.Tab searchForTripTab;
	private ActionBar.Tab createTripTab;
	private ActionBar.Tab profileTab;
	private ImageView imgFavorite;
	
	//fix with concrete classes for Fragment
	Fragment searchForTripFragment = new SearchForTripFragment();
	Fragment createTripFragment = new CreateTripFragment();
	Fragment profileTabFragment = new MyProfileFragment();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        setContentView(R.layout.activity_main_page);
        
        searchForTripTab = actionBar.newTab().setText(R.string.tab_find_trip);
        createTripTab = actionBar.newTab().setText(R.string.tab_create_trip);
        profileTab = actionBar.newTab().setText(R.string.tab_profile);
        
        searchForTripTab.setTabListener(new TabListener(searchForTripFragment));
        createTripTab.setTabListener(new TabListener(createTripFragment));
        profileTab.setTabListener(new TabListener(profileTabFragment));
        
        actionBar.addTab(searchForTripTab);
        actionBar.addTab(createTripTab);
        actionBar.addTab(profileTab);
	}
}
