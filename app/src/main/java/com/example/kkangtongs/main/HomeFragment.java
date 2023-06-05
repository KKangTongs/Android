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
import com.example.kkangtongs.processor.LocationProcessor;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView buildingList;
    RecyclerView.Adapter adapter_building;
    ArrayList<String> buildingData = new ArrayList<>();
    ArrayList<String> nearBuildingList = new ArrayList<>();

    LocationProcessor locationProcessor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        locationProcessor = new LocationProcessor();
        locationProcessor.updateCurrentLocation(getActivity());

        // List<String>으로 바꿀 예정
        List<Location> SortedBuildings = locationProcessor.getNearestLocations();

        buildingList = (RecyclerView) rootView.findViewById(R.id.home_buildingName_rv);
//        nearBuildingList = locationProcessor.getNearestLocations();

        // 테스트용 더미데이터
        nearBuildingList.add("AI관");
        nearBuildingList.add("가천관");
        nearBuildingList.add("산학협력관");
        nearBuildingList.add("비전타워");
        nearBuildingList.add("바이오나노대학");

        initRecyclerView();
        setBuildingList(nearBuildingList);

        return rootView;
    }

    private void initRecyclerView() {
        adapter_building = new BuildingListRVAdapter(buildingData);
        buildingList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        buildingList.setAdapter(adapter_building);
    }

    private void setBuildingList(List<String> nearBuildingList) {

        for(int i=0; i<nearBuildingList.size(); i++) {
            buildingData.add(nearBuildingList.get(i));
        }
    }
}
