package com.example.kkangtongs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MyPageFragment myPageFragment;
    LectureRoomFragment lectureRoomFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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