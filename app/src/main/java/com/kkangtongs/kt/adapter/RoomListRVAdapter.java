package com.kkangtongs.kt.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kkangtongs.kt.R;
import com.kkangtongs.kt.data.RoomItem;

import java.util.ArrayList;

public class RoomListRVAdapter extends RecyclerView.Adapter<RoomListRVAdapter.ViewHolder> {

    private ArrayList<RoomItem> roomList;

    public RoomListRVAdapter(ArrayList<RoomItem> newRoomList) {
        this.roomList = newRoomList;
    }

    @NonNull
    @Override
    public RoomListRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blue_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomListRVAdapter.ViewHolder holder, int position) {
        holder.onBind(roomList.get(position));
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView buildingName;
        TextView roomNumber;
        TextView remainTime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buildingName = (TextView) itemView.findViewById(R.id.roomItem_buildingName_tv);
            roomNumber = (TextView) itemView.findViewById(R.id.roomItem_roomNumber_tv);
            remainTime = (TextView) itemView.findViewById(R.id.roomItem_remainTime_tv);
        }

        void onBind(RoomItem item) {
            buildingName.setText(item.getBuildingName());
            roomNumber.setText(item.getRoomNumber() + "호");
            if (item.getRemainTime() == 9999 && !item.isInclass()){
                remainTime.setText("오늘 수업 없음");
            }else if (item.isInclass()){
                remainTime.setText("현재 수업 중");
            }else {
                remainTime.setText("사용 가능 : " + item.getRemainTime() + "분");
            }
        }
    }
}
