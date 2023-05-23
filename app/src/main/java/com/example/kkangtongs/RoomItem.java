package com.example.kkangtongs;

public class RoomItem {

    String buildingName;
    String roomNumber;
    // String remainTime;
    String day;

    String time;
    /*
    public RoomItem(String buildingName, String roomNumber, String remainTime) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.remainTime = remainTime;
    }*/

    // 강의실 이름과 호수만
    public RoomItem(String buildingName, String roomNumber, String day, String time) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.day = day;
        this.time = time;
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

    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day = day;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

/*
    public String getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = remainTime;
    }
    */
}
