package com.example.kkangtongs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.kkangtongs.data.RoomItem;
import com.example.kkangtongs.main.HomeFragment;
import com.example.kkangtongs.main.LectureRoomFragment;
import com.example.kkangtongs.main.MyPageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MyPageFragment myPageFragment;
    LectureRoomFragment lectureRoomFragment;


    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    public String currentTime = dateFormat.format(new Date());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<RoomItem> gachon_gwan = RoomItemProcessor.roomNameToRoomArray(getApplicationContext(), "가천관");
        ArrayList<RoomItem> ai_gwan = RoomItemProcessor.roomNameToRoomArray(getApplicationContext(), "AI관");

        Log.d("roomItems", gachon_gwan.toString());

        // 지금 위치에서 제일 가까운 건물들을 정렬하여 가져옵니다.
        List<Location> SortedBuildings = LocationProcessor.currentLocationNearestLocations(this);

        homeFragment = new HomeFragment();
        lectureRoomFragment = new LectureRoomFragment();
        myPageFragment = new MyPageFragment();

        // 초기화면을 홈 탭으로 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, homeFragment).commit();

        // 메뉴 선택 시 전환 코드
        BottomNavigationView BNV = (BottomNavigationView) findViewById(R.id.main_bnv);
        BNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, homeFragment).commit();
                        return true;
                    case R.id.lectureRoomFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, lectureRoomFragment).commit();
                        return true;
                    case R.id.myPageFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm, myPageFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }




}