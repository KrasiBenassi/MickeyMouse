package com.mickeymouse.ridewithmeapp.Activities;

import SwipeTabComponents.CustomPagerAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.mickeymouse.ridewithmeapp.R;

public class MainPageActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		setContentView(R.layout.activity_main_page);
		
		ViewPager viewPager = (ViewPager)findViewById(R.id.my_pager);
		CustomPagerAdapter myPagerAdapter = new CustomPagerAdapter(
				getSupportFragmentManager());
		viewPager.setAdapter(myPagerAdapter);
		
	}

}
