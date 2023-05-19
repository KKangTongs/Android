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

    ImageView arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f;
    RecyclerView roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f;
    RecyclerView.Adapter adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f;

    ArrayList<RoomItem> roomData_1f = new ArrayList<>();
    ArrayList<RoomItem> roomData_2f = new ArrayList<>();
    ArrayList<RoomItem> roomData_3f = new ArrayList<>();
    ArrayList<RoomItem> roomData_4f = new ArrayList<>();
    ArrayList<RoomItem> roomData_5f = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ai, container, false);

        // 층별 화살표
        arrow_1f = (ImageView) rootView.findViewById(R.id.ai_1f_iv);
        arrow_2f = (ImageView) rootView.findViewById(R.id.ai_2f_iv);
        arrow_3f = (ImageView) rootView.findViewById(R.id.ai_3f_iv);
        arrow_4f = (ImageView) rootView.findViewById(R.id.ai_4f_iv);
        arrow_5f = (ImageView) rootView.findViewById(R.id.ai_5f_iv);

        // 층별 강의실 정보
        roomList_1f = (RecyclerView) rootView.findViewById(R.id.ai_1f_rv);
        roomList_2f = (RecyclerView) rootView.findViewById(R.id.ai_2f_rv);
        roomList_3f = (RecyclerView) rootView.findViewById(R.id.ai_3f_rv);
        roomList_4f = (RecyclerView) rootView.findViewById(R.id.ai_4f_rv);
        roomList_5f = (RecyclerView) rootView.findViewById(R.id.ai_5f_rv);

        // RecyclerView & Adapter 관련 코드
        initRecyclerView();

        // 층별 데이터 추가
        addRoomList();


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

        arrow_2f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_2f.getVisibility() == View.GONE) {
                    roomList_2f.setVisibility(View.VISIBLE);
                    arrow_2f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_2f.setVisibility(View.GONE);
                    arrow_2f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        arrow_3f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_3f.getVisibility() == View.GONE) {
                    roomList_3f.setVisibility(View.VISIBLE);
                    arrow_3f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_3f.setVisibility(View.GONE);
                    arrow_3f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        arrow_4f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_4f.getVisibility() == View.GONE) {
                    roomList_4f.setVisibility(View.VISIBLE);
                    arrow_4f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_4f.setVisibility(View.GONE);
                    arrow_4f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        arrow_5f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_5f.getVisibility() == View.GONE) {
                    roomList_5f.setVisibility(View.VISIBLE);
                    arrow_5f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_5f.setVisibility(View.GONE);
                    arrow_5f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        return rootView;
    }

    // RecyclerView 초기화 코드
    private void initRecyclerView() {

        // Adapter 선언과 데이터 넘겨주기
        adapter_1f = new RoomListRVAdapter(roomData_1f);
        adapter_2f = new RoomListRVAdapter(roomData_2f);
        adapter_3f = new RoomListRVAdapter(roomData_3f);
        adapter_4f = new RoomListRVAdapter(roomData_4f);
        adapter_5f = new RoomListRVAdapter(roomData_5f);

        // RecyclerView의 LayoutManager 설정
        roomList_1f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_2f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_3f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_4f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_5f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // 층별 RecyclerView와 Adapter 연결
        roomList_1f.setAdapter(adapter_1f);
        roomList_2f.setAdapter(adapter_2f);
        roomList_3f.setAdapter(adapter_3f);
        roomList_4f.setAdapter(adapter_4f);
        roomList_5f.setAdapter(adapter_5f);
    }

    private void addRoomList() {
        // 더미 데이터 테스트 코드

        // 1층 데이터
        roomData_1f.add(new RoomItem("AI", "101", "60"));
        roomData_1f.add(new RoomItem("AI", "105", "100"));

        // 2층 데이터
        roomData_2f.add(new RoomItem("AI", "203", "120"));
        roomData_2f.add(new RoomItem("AI", "225", "87"));

        // 3층 데이터
        roomData_3f.add(new RoomItem("AI", "313", "59"));
        roomData_3f.add(new RoomItem("AI", "309", "100"));

        // 4층 데이터
        roomData_4f.add(new RoomItem("AI", "401", "20"));
        roomData_4f.add(new RoomItem("AI", "404", "40"));

        // 5층 데이터
        roomData_5f.add(new RoomItem("AI", "509", "60"));
        roomData_5f.add(new RoomItem("AI", "511", "70"));


        // 데이터 변경사항 알리는 코드
        adapter_1f.notifyDataSetChanged();
        adapter_2f.notifyDataSetChanged();
        adapter_3f.notifyDataSetChanged();
        adapter_4f.notifyDataSetChanged();
        adapter_5f.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();


    }
}
