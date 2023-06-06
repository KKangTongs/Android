package com.example.kkangtongs.main;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kkangtongs.R;
import com.example.kkangtongs.adapter.BuildingListRVAdapter;
import com.example.kkangtongs.adapter.RoomListRVAdapter;
import com.example.kkangtongs.data.RoomItem;
import com.example.kkangtongs.processor.LocationProcessor;
import com.example.kkangtongs.processor.RoomItemProcessor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    // 건물 관련 변수
    RecyclerView buildingList;
    RecyclerView.Adapter adapter_building;
    ArrayList<String> buildingData = new ArrayList<>();
    ArrayList<String> nearBuildingList = new ArrayList<>();
    LocationProcessor locationProcessor;

    // 강의실 관련 변수
    RecyclerView roomDataList;
    ArrayList<RoomItem> roomData = new ArrayList<>();
    RecyclerView.Adapter adapter_class;
    ArrayList<RoomItem> selectedBuildingRoom = new ArrayList<>();

    // 시간 관련 변수
    int currentDayOfWeek;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        buildingList = (RecyclerView) rootView.findViewById(R.id.home_buildingName_rv);
        roomDataList = (RecyclerView) rootView.findViewById(R.id.home_classList_rv);

        // 가장 가까운 건물 리스트 가져오기
        locationProcessor = new LocationProcessor();
        locationProcessor.updateCurrentLocation(getActivity());
        nearBuildingList = locationProcessor.getNearestLocationsOnlyName();
        Log.d("NEAR", nearBuildingList.toString());

        // RecyclerView & Adapter 세팅
        initRecyclerView();

        // 가까운 건물 리스트 업데이트
        setBuildingList(nearBuildingList);

        // 강의실 업데이트
        setRoomList();

        return rootView;
    }

    private void initRecyclerView() {
        adapter_building = new BuildingListRVAdapter(buildingData);
        buildingList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        buildingList.setAdapter(adapter_building);

        adapter_class = new RoomListRVAdapter(roomData);
        roomDataList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomDataList.setAdapter(adapter_class);
    }

    private void setBuildingList(ArrayList<String> nearBuildingList) {

        for(int i=0; i<nearBuildingList.size(); i++) {
            buildingData.add(nearBuildingList.get(i));
        }
    }

    private void setRoomList() {

        // 임시로 AI관 사용
        String selectedBuilding = "AI관";

        // 추후에 setRoomList()로 selectedBuilding을 매개변수로 들어올 것임
        selectedBuildingRoom = RoomItemProcessor.roomNameToRoomArray(getContext(), selectedBuilding);

        // 현재 요일
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (RoomItem roomItem : selectedBuildingRoom) {
            // 오늘 수업이 없는 곳만 골라내기 위함
            if(currentDayOfWeek != getDayOfWeek(roomItem.getDay())) {

                boolean isExist = false;

                for (RoomItem rd : roomData) {
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                        isExist = true;
                        break;
                    }
                }

                if(!isExist) {
                    roomData.add(roomItem);
                }
            }
        }

        // 데이터 변경사항 알리는 코드
        adapter_class.notifyDataSetChanged();
    }

    private static int getDayOfWeek(String day) {
        switch (day) {
            case "일":
                return 1;
            case "월":
                return 2;
            case "화":
                return 3;
            case "수":
                return 4;
            case "목":
                return 5;
            case "금":
                return 6;
            case "토":
                return 7;
            default:
                return -1;
        }
    }
}
