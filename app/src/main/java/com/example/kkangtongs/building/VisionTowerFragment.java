package com.example.kkangtongs.building;

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

import com.example.kkangtongs.R;
import com.example.kkangtongs.adapter.RoomListRVAdapter;
import com.example.kkangtongs.data.RoomItem;

import java.util.ArrayList;

public class VisionTowerFragment extends Fragment {

    ImageView arrow_b2, arrow_b1, arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f, arrow_6f;
    RecyclerView roomList_b2, roomList_b1, roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f, roomList_6f;
    RecyclerView.Adapter adapter_b2, adapter_b1, adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f, adapter_6f;

    ArrayList<RoomItem> roomData_b2 = new ArrayList<>();
    ArrayList<RoomItem> roomData_b1 = new ArrayList<>();
    ArrayList<RoomItem> roomData_1f = new ArrayList<>();
    ArrayList<RoomItem> roomData_2f = new ArrayList<>();
    ArrayList<RoomItem> roomData_3f = new ArrayList<>();
    ArrayList<RoomItem> roomData_4f = new ArrayList<>();
    ArrayList<RoomItem> roomData_5f = new ArrayList<>();
    ArrayList<RoomItem> roomData_6f = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_visiontower, container, false);


        // 층별 화살표
        arrow_b2 = (ImageView) rootView.findViewById(R.id.vision_B2_iv);
        arrow_b1 = (ImageView) rootView.findViewById(R.id.vision_B1_iv);
        arrow_1f = (ImageView) rootView.findViewById(R.id.vision_1f_iv);
        arrow_2f = (ImageView) rootView.findViewById(R.id.vision_2f_iv);
        arrow_3f = (ImageView) rootView.findViewById(R.id.vision_3f_iv);
        arrow_4f = (ImageView) rootView.findViewById(R.id.vision_4f_iv);
        arrow_5f = (ImageView) rootView.findViewById(R.id.vision_5f_iv);
        arrow_6f = (ImageView) rootView.findViewById(R.id.vision_6f_iv);

        // 층별 강의실 정보
        roomList_b2 = (RecyclerView) rootView.findViewById(R.id.vision_B2_rv);
        roomList_b1 = (RecyclerView) rootView.findViewById(R.id.vision_B1_rv);
        roomList_1f = (RecyclerView) rootView.findViewById(R.id.vision_1f_rv);
        roomList_2f = (RecyclerView) rootView.findViewById(R.id.vision_2f_rv);
        roomList_3f = (RecyclerView) rootView.findViewById(R.id.vision_3f_rv);
        roomList_4f = (RecyclerView) rootView.findViewById(R.id.vision_4f_rv);
        roomList_5f = (RecyclerView) rootView.findViewById(R.id.vision_5f_rv);
        roomList_6f = (RecyclerView) rootView.findViewById(R.id.vision_6f_rv);

        // RecyclerView & Adapter 관련 코드
        initRecyclerView();

        // 층별 강의실 데이터 세팅
        setRoomList();


        // 층별 화살표에 대한 Click Listener
        arrow_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_b2.getVisibility() == View.GONE) {
                    roomList_b2.setVisibility(View.VISIBLE);
                    arrow_b2.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_b2.setVisibility(View.GONE);
                    arrow_b2.animate().setDuration(200).rotation(0f);
                }
            }
        });
        arrow_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_b1.getVisibility() == View.GONE) {
                    roomList_b1.setVisibility(View.VISIBLE);
                    arrow_b1.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_b1.setVisibility(View.GONE);
                    arrow_b1.animate().setDuration(200).rotation(0f);
                }
            }
        });

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

        arrow_6f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_6f.getVisibility() == View.GONE) {
                    roomList_6f.setVisibility(View.VISIBLE);
                    arrow_6f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_6f.setVisibility(View.GONE);
                    arrow_6f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        return rootView;
    }


    // RecyclerView 초기화 코드
    private void initRecyclerView() {

        // Adapter 선언과 데이터 넘겨주기
        adapter_b2 = new RoomListRVAdapter(roomData_b2);
        adapter_b1 = new RoomListRVAdapter(roomData_b1);
        adapter_1f = new RoomListRVAdapter(roomData_1f);
        adapter_2f = new RoomListRVAdapter(roomData_2f);
        adapter_3f = new RoomListRVAdapter(roomData_3f);
        adapter_4f = new RoomListRVAdapter(roomData_4f);
        adapter_5f = new RoomListRVAdapter(roomData_5f);
        adapter_6f = new RoomListRVAdapter(roomData_6f);

        // RecyclerView의 LayoutManager 설정
        roomList_b2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_b1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_1f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_2f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_3f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_4f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_5f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_6f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // 층별 RecyclerView와 Adapter 연결
        roomList_b2.setAdapter(adapter_b2);
        roomList_b1.setAdapter(adapter_b1);
        roomList_1f.setAdapter(adapter_1f);
        roomList_2f.setAdapter(adapter_2f);
        roomList_3f.setAdapter(adapter_3f);
        roomList_4f.setAdapter(adapter_4f);
        roomList_5f.setAdapter(adapter_5f);
        roomList_6f.setAdapter(adapter_6f);
    }


    private void setRoomList() {

        // 데이터 변경사항 알리는 코드
        adapter_b2.notifyDataSetChanged();
        adapter_b1.notifyDataSetChanged();
        adapter_1f.notifyDataSetChanged();
        adapter_2f.notifyDataSetChanged();
        adapter_3f.notifyDataSetChanged();
        adapter_4f.notifyDataSetChanged();
        adapter_5f.notifyDataSetChanged();
        adapter_6f.notifyDataSetChanged();

    }
}
