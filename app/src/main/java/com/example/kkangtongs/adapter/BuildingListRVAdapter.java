package com.example.kkangtongs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kkangtongs.R;

import java.util.ArrayList;

public class BuildingListRVAdapter extends RecyclerView.Adapter<BuildingListRVAdapter.ViewHolder> {

    private ArrayList<String> buildingList;

    public BuildingListRVAdapter(ArrayList<String> newBuildingLIst) {
        this.buildingList = newBuildingLIst;
    }


    @NonNull
    @Override
    public BuildingListRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_building_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingListRVAdapter.ViewHolder holder, int position) {
        holder.onBind(buildingList.get(position));
    }

    @Override
    public int getItemCount() {
        return buildingList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView buildingName;
        TextView emptyroomNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buildingName = (TextView) itemView.findViewById(R.id.building_name_tv);
            emptyroomNum = (TextView) itemView.findViewById(R.id.building_emptyroomNum_tv);
        }

        void onBind(String newBuildingName) {
            buildingName.setText(newBuildingName);
        }
    }
}
