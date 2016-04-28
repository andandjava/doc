package com.example.fragmentmap;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GetAddressActivity extends Activity implements LocationListener {
	
String LATITUDE ;
String LONGITUDE ;
private TextView latituteField;
private TextView longitudeField;
private LocationManager locationManager;
private String provider;
String lats,lngs;
Button getadd_btn;
double latd,logd;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truiton_map_fragment);
        TextView myLatitude = (TextView)findViewById(R.id.mylatitude);
        TextView myLongitude = (TextView)findViewById(R.id.mylongitude);
        TextView myAddress = (TextView)findViewById(R.id.myaddress);
        
        latituteField = (TextView) findViewById(R.id.TextView02);
        longitudeField = (TextView) findViewById(R.id.TextView04);

        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (location != null) {
          System.out.println("Provider " + provider + " has been selected.");
          onLocationChanged(location);
        } else {
          latituteField.setText("Location not available");
          longitudeField.setText("Location not available");
        }
//        LATITUDE=getIntent().getExtras().getString("LAT");
//        LONGITUDE=getIntent().getExtras().getString("LNG");
//        double valuelat = Double.parseDouble(LATITUDE);
//        double valuelng = Double.parseDouble(LONGITUDE);
        myLatitude.setText("Latitude: " + lats);
        myLongitude.setText("Longitude: " + lngs);
        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);

        try {
			List<Address> addresses = geocoder.getFromLocation(latd, logd, 1);
			
			if(addresses != null) {
				Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("Address:\n");
				for(int i=0; i<returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
				}
				myAddress.setText(strReturnedAddress.toString());
			}
			else{
				myAddress.setText("No Address returned!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myAddress.setText("Canont get Address!");
		}

    }
      

      /* Request updates at startup */
      @Override
      protected void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
      }

      /* Remove the locationlistener updates when Activity is paused */
      @Override
      protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
      }

      @Override
      public void onLocationChanged(Location location) {
        int lat = (int) (location.getLatitude());
        latd=(double) lat;
        int lng = (int) (location.getLongitude());
        logd=(double) lng;
        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
        lats=String.valueOf(latd);
        lngs=String.valueOf(logd);
       
      }

      @Override
      public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
            Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
            Toast.LENGTH_SHORT).show();
      }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
      
}