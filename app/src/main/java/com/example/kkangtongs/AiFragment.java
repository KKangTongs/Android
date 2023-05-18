package com.example.kkangtongs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AiFragment extends Fragment {

    ImageView arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f, arrow_6f;
    RecyclerView roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f, roomList_6f;
    RecyclerView.Adapter adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f, adapter_6f;

    ArrayList<RoomItem> roomList = new ArrayList<RoomItem>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ai, container, false);

        // 층별 화살표
        arrow_1f = (ImageView) rootView.findViewById(R.id.ai_1f_iv);

        // 층별 강의실 정보
        roomList_1f = (RecyclerView) rootView.findViewById(R.id.ai_1f_rv);

        // RecyclerView & Adapter 관련 코드
        initRecyclerView();



        // 더미 데이터 테스트 코드
        roomList.add(new RoomItem("AI", "301", "60"));
        roomList.add(new RoomItem("AI", "402", "100"));
        roomList.add(new RoomItem("AI", "205", "80"));


        adapter_1f.notifyDataSetChanged();


        // 층별 화살표에 대한 Click Listener
        arrow_1f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_1f.getVisibility() == View.GONE) {
                    roomList_1f.setVisibility(View.VISIBLE);
                    arrow_1f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_1f.setVisibility(View.GONE);
                    arrow_1f.animate().setDuration(200).rotation(0f);
                }
            }
        });




        return rootView;
    }

    // RecyclerView 초기화 코드
    private void initRecyclerView() {

        // Adapter 선언과 데이터 넘겨주기
        adapter_1f = new RoomListRVAdapter(roomList);

        // 층별 RecyclerView와 Adapter 연결
        roomList_1f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_1f.setAdapter(adapter_1f);
    }

    @Override
    public void onStart() {
        super.onStart();


    }
}
