package com.track.mylocation;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MyLocation extends Activity {
    /** Called when the activity is first created. */
	Button retrieveLocationButton;
	LocationManager locationManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        retrieveLocationButton = (Button)findViewById(R.id.retrieve_location_button);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 1000, new MyLocationListener());
        retrieveLocationButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showCurrentLocation();
			}
		});
        
    }
    
    protected void showCurrentLocation() {
    	Location location =	locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	if(location!=null){
			String message = String.format(
					"Current location \n Latitude: %1$s \n Longitude: %2$s",
					location.getLatitude(), location.getLongitude()
					);
			Toast.makeText(MyLocation.this, message, Toast.LENGTH_LONG).show();
    	}
		
	}

	private class MyLocationListener implements LocationListener{

		public void onLocationChanged(Location location) {
			String message = String.format(
					"New Location \n Latitude: %1$s \n Longitude: %2$s",
					location.getLatitude(), location.getLongitude()
					);
			Toast.makeText(MyLocation.this, message, Toast.LENGTH_LONG).show();
		}

		public void onProviderDisabled(String provider) {
			Toast.makeText(MyLocation.this, "Provider disabled by the user, GPS is turned off!",
					Toast.LENGTH_LONG).show();
		}

		public void onProviderEnabled(String provider) {
			Toast.makeText(MyLocation.this, "Provider enabled by the user, GPS is truned on!", Toast.LENGTH_LONG).show();
			
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			Toast.makeText(MyLocation.this, "Provider status changed!", Toast.LENGTH_LONG).show();
			
		}
    	
    }
}