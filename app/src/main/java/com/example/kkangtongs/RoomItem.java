package com.example.kkangtongs;

public class RoomItem {

    String buildingName;
    String roomNumber;
    String remainTime;

    public RoomItem(String buildingName, String roomNumber, String remainTime) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.remainTime = remainTime;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = remainTime;
    }
}
