package LocalStorage;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mickeymouse.ridewithmeapp.Models.Trip;
import com.telerik.everlive.sdk.core.model.system.User;

public class LocalDb extends SQLiteOpenHelper{
	private static final int DB_VER = 1;
	private static final String KEY_ID = "id";
	private static final String KEY_DEP_TOWN = "dep_town";
	private static final String KEY_DEST_TOWN = "dest_town";
	private static final String KEY_HOST = "host";
	private static final String KEY_SIGNED_PEOPLE = "signed_people";
	private static final String KEY_TOTAL_SEATS = "total_seats";
	private static final String KEY_DEP_DATE = "dep_date";
	private static final String KEY_DEP_TIME = "dep_time";
	
	private final String tableName;
	private final String createDbString;
	
	public LocalDb(Context context, String dbName, String tableName) {
		super(context, dbName, null, DB_VER);
		this.tableName = tableName;
		this.createDbString = "create table " + tableName +
				 "( " + KEY_ID + " integer primary key autoincrement, " +
						KEY_DEP_TOWN + " text not null, " +
						KEY_DEST_TOWN + " text not null, " +
						KEY_HOST 	 + " text not null, " +
						KEY_SIGNED_PEOPLE + " text not null, " +
						KEY_TOTAL_SEATS + " integer, " + 
						KEY_DEP_DATE + " text not null, " +
						KEY_DEP_TIME + " text not null); ";
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(createDbString);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + tableName);
		onCreate(db);
	}
	
	public void addTrip(Trip tripInfo){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues newRow = new ContentValues();
		newRow.put(KEY_DEP_TOWN, tripInfo.getDeparturePoint());
		newRow.put(KEY_DEST_TOWN, tripInfo.getDestinationPoint());
		newRow.put(KEY_HOST, tripInfo.getHost());
		
		StringBuilder builder = new StringBuilder();
		List<String> signedPeople = tripInfo.getSignedPeople();
		for(String user : signedPeople){
			//too lazy
			builder.append(user + "|");
		}
		newRow.put(KEY_SIGNED_PEOPLE, builder.toString());
		newRow.put(KEY_TOTAL_SEATS, tripInfo.getTotalSeats());
		
		newRow.put(KEY_DEP_DATE, tripInfo.getDate());
		newRow.put(KEY_DEP_TIME, tripInfo.getTime());
		db.insert(tableName, null, newRow);
	}
	
	public List<Trip> getTrips(){
		List<Trip> tripList = new ArrayList<Trip>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from " + tableName, null);
		if(cursor.moveToFirst()){
			do{
				Trip currTrip = new Trip();
				currTrip.setDeparturePoint(cursor.getString(1));
				currTrip.setDestinationPoint(cursor.getString(2));
				
				//User curruser = new User();
				//curruser.setDisplayName(cursor.getString(3));
				currTrip.setHost(cursor.getString(3));
				
				String signedPeople = cursor.getString(4);
				String[] signedPeopleList = signedPeople.split("|");
				List <String> retSignedUserList = currTrip.getSignedPeople();
				
				for(String signedPeopleListItem : signedPeopleList){
					retSignedUserList.add(signedPeopleListItem);
				}
				
				currTrip.setTotalSeats(cursor.getInt(5));

				currTrip.setDate(cursor.getString(6));
				currTrip.setTime(cursor.getString(7));
				tripList.add(currTrip);
			}while(cursor.moveToNext());
		}
		db.close();

		return tripList;
	}
}
