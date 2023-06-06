package com.kkangtongs.kt.main;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import com.kkangtongs.kt.R;
import com.kkangtongs.kt.TimePickerDialog;
import com.kkangtongs.kt.TimePickerDialogListener;
import com.kkangtongs.kt.adapter.ContentsPagerAdapter;
import com.kkangtongs.kt.processor.TimeProcessor;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.greenrobot.eventbus.EventBus;

import java.util.Arrays;
import java.util.List;

public class LectureRoomFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ContentsPagerAdapter contentsPagerAdapter;
    private Button timeBtn;
    private TextView timeInfo;
    public String time;

    final List<String> tabElement = Arrays.asList("AI공학관", "비전타워", "산학협력관", "가천관", "바이오나노대학");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lectureroom, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.lectureRoom_tabLayout_tb);
        viewPager = (ViewPager2) rootView.findViewById(R.id.lectureRoom_viewpager_vp);
        contentsPagerAdapter = new ContentsPagerAdapter((AppCompatActivity) getActivity());
        timeBtn = (Button) rootView.findViewById(R.id.time_btn);
        timeInfo = (TextView) rootView.findViewById(R.id.time_registerTime_tv);

        // 현재 시간으로 default 세팅
        time = TimeProcessor.getTime();
        timeInfo.setText(TimeProcessor.time);


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
                        EventBus.getDefault().post(new DataEvent(time));
                    }

                    @Override
                    public void onCancelClick() {
                        //취소 버튼 눌렀을 때
                    }
                });

                timeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //이 코드 없으면 다이얼로그 rounding 처리가 안됨
                timeDialog.setCanceledOnTouchOutside(false);
                timeDialog.setCancelable(true);
                timeDialog.show();
            }
        });





        return rootView;
    }

    public static class DataEvent {

        public final String time;

        public DataEvent(String newTime) {
            this.time = newTime;
        }
    }

}
