package com.example.kkangtongs.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.kkangtongs.R;
import com.example.kkangtongs.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class LectureRoomFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ContentsPagerAdapter contentsPagerAdapter;

    final List<String> tabElement = Arrays.asList("AI공학관", "비전타워", "산학협력관2", "가천관", "바이오나노대학");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lectureroom, container, false);

        tabLayout = (TabLayout) rootView.findViewById(R.id.lectureRoom_tabLayout_tb);
        viewPager = (ViewPager2) rootView.findViewById(R.id.lectureRoom_viewpager_vp);
        contentsPagerAdapter = new ContentsPagerAdapter((AppCompatActivity) getActivity());

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


        return rootView;
    }
}
