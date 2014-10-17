package SwipeTabComponents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class CustomPagerAdapter extends FragmentStatePagerAdapter{

	public CustomPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int pos) {
		switch(pos){
		case 0:
			return new SearchForTripFragment();
		case 1:
			return new CreateTripFragment();
		case 2:
			return new MyProfileFragment();
		}
		Log.e("ERROR", "null");
		return null;
	}
	
	@Override
	public CharSequence getPageTitle(int pos) {
		//strings should be loaded from resource
		switch(pos){
		case 0:
			return new String("Search for trip");
		case 1:
			return new String("Create trip");
		case 2:
			return new String("My profile");
		}
		
		return null;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
