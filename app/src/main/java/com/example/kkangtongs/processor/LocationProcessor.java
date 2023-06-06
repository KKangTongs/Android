package com.example.kkangtongs.processor;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LocationProcessor {
    Location currentLocation = new Location("current");

    // 현재 위치를 업데이트하는 메소드
    public void updateCurrentLocation(Activity activity) {

        try {
            LocationManager locationManager = (LocationManager) activity.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

            // 위치가 바뀌었을 때 호출되는 LocationListener
            LocationListener locationListener = new LocationListener() {

                // 위치가 바뀌었을때
                @Override
                public void onLocationChanged(Location location) {
                    // 위도(latitude)와 경도(longitude)를 가져옴
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Log.d("MyLocation", "Latitude: " + latitude + ", Longitude: " + longitude);
                    currentLocation.set(location);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                @Override
                public void onProviderEnabled(String provider) {
                }

                @Override
                public void onProviderDisabled(String provider) {
                }
            };

            // 위치 권한을 확인하고 요청
            if (ActivityCompat.checkSelfPermission(activity.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity.getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // 위치 권한이 허용되지 않은 경우 권한 요청
                ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }

            // GPS_PROVIDER를 통해 위치 업데이트 요청
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    // 가장 가까운 위치들을 반환하는 메서드
    public List<Location> getNearestLocations() {
        List<Location> locations = new ArrayList<>();

        // 건물 위치 좌표 추가
        locations.add(createLocation("비전타워_(1)", 37.450125, 127.127316));
        locations.add(createLocation("비전타워_(2)", 37.449364, 127.127756));
        locations.add(createLocation("산학협력관2_(1)", 37.451442, 127.126913));
        locations.add(createLocation("산학협력관2_(2)", 37.450782, 127.127310));
        locations.add(createLocation("AI관_(1)", 37.455372, 127.133354));
        locations.add(createLocation("AI관_(2)", 37.455170, 127.134294));
        locations.add(createLocation("바이오나노대학_(1)", 37.452805, 127.128711));
        locations.add(createLocation("바이오나노대학_(2)", 37.452381, 127.130057));

        // 거리 계산 및 정렬
        Collections.sort(locations, new Comparator<Location>() {
            @Override
            public int compare(Location location1, Location location2) {
                float distance1 = currentLocation.distanceTo(location1);
                float distance2 = currentLocation.distanceTo(location2);
                return Float.compare(distance1, distance2);
            }
        });

        return locations;
    }

    // 이름, 위도, 경도를 이용하여 Location 객체를 생성하는 메서드
    private static Location createLocation(String name, double latitude, double longitude) {
        Location location = new Location(name);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        return location;
    }


}
