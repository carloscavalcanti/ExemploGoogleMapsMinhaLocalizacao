package com.example.exemplogooglemapsminhalocalizacao;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class MainActivity extends MapActivity implements LocationListener {

	private MapView mapView;
	private MyLocationOverlay myLocationOverlay;
	private LocationManager locationManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setTraffic(true);
		mapView.setClickable(true);
		
		pegarMinhaLocalizacao();
		
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, this);
		boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (!gpsEnabled) {
			Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(settingsIntent);
		}
	}

	private void pegarMinhaLocalizacao() {
		myLocationOverlay = new MyLocationOverlay(this, mapView);
		myLocationOverlay.enableCompass(); //Ativar bussola
		myLocationOverlay.enableMyLocation();
		mapView.getOverlays().add(myLocationOverlay);        
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	/*private void updateLocation(Location location) {
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			String currentLocation = "The location is changed to Lat: " + lat + " Lng: " + lng;
			System.out.println(currentLocation);
			GeoPoint geoPoint = new GeoPoint((int) lat * 1000000, (int) lng * 1000000);

			mapView.getController().animateTo(geoPoint);
			mapView.getOverlays().clear();
			mapView.getOverlays().add(new CirculoOverlay(geoPoint));
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
	
	private class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			System.out.println("onLocationChanged");
			updateLocation(location);
		}

		@Override
		public void onProviderDisabled(String arg0) {
			System.out.println("onProviderDisabled");

		}

		@Override
		public void onProviderEnabled(String arg0) {
			System.out.println("onProviderEnabled");

		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {		
			System.out.println("onStatusChanged");
		}		
	}
*/

}
