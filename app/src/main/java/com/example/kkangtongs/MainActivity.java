package com.example.kkangtongs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.kkangtongs.main.HomeFragment;
import com.example.kkangtongs.main.LectureRoomFragment;
import com.example.kkangtongs.main.MyPageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MyPageFragment myPageFragment;
    LectureRoomFragment lectureRoomFragment;

    public static ArrayList<JSONArray> gachon_gwan;  // 가천관
    public static ArrayList<JSONArray> AI_gwan;  // AI관
    public static ArrayList<JSONArray> vision_tower;  // 비전타워
    public static ArrayList<JSONArray> bio_yeongu;  // 바이오나노연구
    public static ArrayList<JSONArray> bio_nano_dae;  // 바이오나노대학
    public static ArrayList<JSONArray> sanhak_hyeop2;  // 산학협력관2
    public static ArrayList<JSONArray> sanhak_hyeop;  // 산학협력관
    public static ArrayList<JSONArray> gyoyook_daehakwon;  // 교육대학원
    public static ArrayList<JSONArray> gongghwa2;  // 공과대학2
    public static ArrayList<JSONArray> gongghwa1;  // 공과대학1
    public static ArrayList<JSONArray> yesul2;  // 예술대학2
    public static ArrayList<JSONArray> yesul1;  // 예술대학1
    public static ArrayList<JSONArray> global_center;  // 글로벌센터
    public static ArrayList<JSONArray> hanuigwa; // 한의과대학


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gachon_gwan = new ArrayList<>();  // 가천관
        AI_gwan = new ArrayList<>();  // AI관
        vision_tower = new ArrayList<>();  // 비전타워
        bio_yeongu = new ArrayList<>();  // 바이오나노연구
        bio_nano_dae = new ArrayList<>();  // 바이오나노대학
        sanhak_hyeop2 = new ArrayList<>();  // 산학협력관2
        sanhak_hyeop = new ArrayList<>();  // 산학협력관
        gyoyook_daehakwon = new ArrayList<>();  // 교육대학원
        gongghwa2 = new ArrayList<>();  // 공과대학2
        gongghwa1 = new ArrayList<>();  // 공과대학1
        yesul2 = new ArrayList<>();  // 예술대학2
        yesul1 = new ArrayList<>();  // 예술대학1
        global_center = new ArrayList<>();  // 글로벌센터
        hanuigwa = new ArrayList<>();  // 한의과대학

        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(getApplicationContext(), "gachon_timetable.json")); // jsonString은 주어진 JSON 문자열입니다.

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray innerArray = jsonArray.getJSONArray(i);
                String value = innerArray.getString(6); // 8번째 인덱스 값 가져오기 (인덱스는 0부터 시작하므로 7을 사용)

                if (value.contains("가천관")) {
                    MainActivity.gachon_gwan.add(innerArray);
                }
                if (value.contains("AI")) {
                    MainActivity.AI_gwan.add(innerArray);
                }
                if (value.contains("비전타워")) {
                    MainActivity.vision_tower.add(innerArray);
                }
                if (value.contains("바이오나노연구")) {
                    MainActivity.bio_yeongu.add(innerArray);
                }
                if (value.contains("바이오나노대학")) {
                    MainActivity.bio_nano_dae.add(innerArray);
                }
                if (value.contains("산학협력관2")) {
                    MainActivity.sanhak_hyeop2.add(innerArray);
                }
                if (value.contains("산학협력관-")) {
                    MainActivity.sanhak_hyeop.add(innerArray);
                }
                if (value.contains("교육대학원")) {
                    MainActivity.gyoyook_daehakwon.add(innerArray);
                }
                if (value.contains("공과대학2")) {
                    MainActivity.gongghwa2.add(innerArray);
                }
                if (value.contains("공과대학1")) {
                    MainActivity.gongghwa1.add(innerArray);
                }
                if (value.contains("예술대학2")) {
                    MainActivity.yesul2.add(innerArray);
                }
                if (value.contains("예술대학1")) {
                    MainActivity.yesul1.add(innerArray);
                }
                if (value.contains("글로벌센터")) {
                    MainActivity.global_center.add(innerArray);
                }
                if (value.contains("한의과대학")) {
                    MainActivity.hanuigwa.add(innerArray);
                }
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("가천관", gachon_gwan.toString());


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

    private String loadJSONFromAsset(Context context, String filename) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }





}