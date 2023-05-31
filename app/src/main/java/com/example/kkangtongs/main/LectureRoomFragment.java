package com.example.kkangtongs.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.kkangtongs.R;
import com.example.kkangtongs.TimePickerDialog;
import com.example.kkangtongs.TimePickerDialogListener;
import com.example.kkangtongs.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class LectureRoomFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ContentsPagerAdapter contentsPagerAdapter;
    private Button timeBtn;
    private TextView timeInfo;
    public String time;

    final List<String> tabElement = Arrays.asList("AI공학관", "비전타워", "산학협력관2", "가천관", "바이오나노대학");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lectureroom, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.lectureRoom_tabLayout_tb);
        viewPager = (ViewPager2) rootView.findViewById(R.id.lectureRoom_viewpager_vp);
        contentsPagerAdapter = new ContentsPagerAdapter((AppCompatActivity) getActivity());
        timeBtn = (Button) rootView.findViewById(R.id.time_btn);
        timeInfo = (TextView) rootView.findViewById(R.id.time_registerTime_tv);


        // 현재 시간 세팅
        LocalTime now = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 포맷 적용하기
        String formatedNow = now.format(formatter);

        // 시, 분, 초 구하기
        int hour = now.getHour();
        int minute = now.getMinute();

        time = String.format("%02d:%02d", hour, minute);
        timeInfo.setText(time);
        Log.d("LECTURETIME", time);


        // viewpager2에서 overScrollmode를 never로 설정
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        // Viewpager에 adapter 붙이기
        viewPager.setAdapter(contentsPagerAdapter);

        // tablayout과 viewpager 연결
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(getActivity());
                textView.setText(tabElement.get(position));
                tab.setCustomView(textView);
            }
        }).attach();

        // 시간 등록 버튼 눌렀을 때
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timeDialog = new TimePickerDialog(getContext(), new TimePickerDialogListener() {
                    @Override
                    public void onPositiveClick(int hour, int minute) {
                        // 확인버튼 눌렀을 때
                        Log.d("TIME_INPUT", hour + "시 " + minute + "분");

                        time = String.format("%02d:%02d", hour, minute);
                        timeInfo.setText(time);
                    }

                    @Override
                    public void onCancelClick() {
                        //취소 버튼 눌렀을 때
                    }
                });

                timeDialog.setCanceledOnTouchOutside(false);
                timeDialog.setCancelable(true);
                timeDialog.show();
            }
        });





        return rootView;
    }

    public String getTime() {
        return time;
    }

}
