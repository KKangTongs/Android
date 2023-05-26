package com.example.kkangtongs.building;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kkangtongs.MainActivity;
import com.example.kkangtongs.R;
import com.example.kkangtongs.data.RoomItem;
import com.example.kkangtongs.adapter.RoomListRVAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AiFragment extends Fragment {

    ImageView arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f;
    RecyclerView roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f;
    RecyclerView.Adapter adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f;

    ArrayList<RoomItem> roomData_1f = new ArrayList<>();
    ArrayList<RoomItem> roomData_2f = new ArrayList<>();
    ArrayList<RoomItem> roomData_3f = new ArrayList<>();
    ArrayList<RoomItem> roomData_4f = new ArrayList<>();
    ArrayList<RoomItem> roomData_5f = new ArrayList<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    public String currentTime = dateFormat.format(new Date());


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

        // 층별 강의실 데이터 세팅
        setRoomList();


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


    private void setRoomList() {
        // 더미 데이터 대신 MainActivity에서 가져온 데이터 사용
        for (JSONArray innerArray : MainActivity.AI_gwan) {
            try {
                // 강의실 이름 - 호수
                String roomNameNumber = innerArray.getString(6);
                // 강의 요일 - 시간
                String roomDayTime = innerArray.getString(5);


                Date currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);

                int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                // 한 강의에 강의실 2개 쓰는 경우
                if (roomNameNumber.contains(",")){

                    String[] courseParts = roomNameNumber.split(",");// AI관-1호, AI관-2호

                    String roomNameNumber1 = courseParts[0];
                    String roomNameNumber2 = courseParts[1]; // AI관-2호

                    String[] roomParts1 = roomNameNumber1.split("-");
                    String[] roomParts2 = roomNameNumber2.split("-");

                    String roomName1 = roomParts1[0]; // ai관
                    String roomNumber1 = roomParts1[1]; // 1
                    String roomName2 = roomParts2[0];
                    String roomNumber2 = roomParts2[1];

                    // 강의 일주일에 2번
                    String[] dayTimePart = roomDayTime.split(" ,");
                    String dayTime1 = dayTimePart[0];
                    String dayTime2 = dayTimePart[0];

                    String day1 = dayTime1.substring(0, 1); // 수
                    String time1 = dayTime1.substring(1); // 1

                    String day2 = dayTime2.substring(0, 1);
                    String time2 = dayTime2.substring(1);

                    if (currentDayOfWeek == getDayOfWeek(day1)) {
                        if (roomNumber1.startsWith("1")) {
                            roomData_1f.add(new RoomItem(roomName1, roomNumber1, day1, time1));
                        } else if (roomNumber1.startsWith("2")) {
                            roomData_2f.add(new RoomItem(roomName1, roomNumber1, day1, time1));
                        } else if (roomNumber1.startsWith("3")) {
                            roomData_3f.add(new RoomItem(roomName1, roomNumber1, day1, time1));
                        } else if (roomNumber1.startsWith("4")) {
                            roomData_4f.add(new RoomItem(roomName1, roomNumber1, day1, time1));
                        } else if (roomNumber1.startsWith("5")) {
                            roomData_5f.add(new RoomItem(roomName1, roomNumber1, day1, time1));
                        }
                    }

                    if (currentDayOfWeek == getDayOfWeek(day2)) {
                        if (roomNumber2.startsWith("1")) {
                            roomData_1f.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                        } else if (roomNumber2.startsWith("2")) {
                            roomData_2f.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                        } else if (roomNumber2.startsWith("3")) {
                            roomData_3f.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                        } else if (roomNumber2.startsWith("4")) {
                            roomData_4f.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                        } else if (roomNumber2.startsWith("5")) {
                            roomData_5f.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                        }
                    }

                } else { // 강의실 1개

                    String[] roomParts = roomNameNumber.split("-");
                    String[] dayTimePart = roomDayTime.split(" ,");

                    String roomName = roomParts[0];
                    String roomNumber = roomParts[1];

                    for (String dayTime : dayTimePart){
                        String day = dayTime.substring(0,1);
                        String time = dayTime.substring(1);

                        if (currentDayOfWeek == getDayOfWeek(day)) {
                            if (roomNumber.startsWith("1")) {
                                roomData_1f.add(new RoomItem(roomName, roomNumber, day, time));
                            } else if (roomNumber.startsWith("2")) {
                                roomData_2f.add(new RoomItem(roomName, roomNumber, day, time));
                                Log.d("2f", roomNumber);
                            } else if (roomNumber.startsWith("3")) {
                                roomData_3f.add(new RoomItem(roomName, roomNumber, day, time));
                            } else if (roomNumber.startsWith("4")) {
                                roomData_4f.add(new RoomItem(roomName, roomNumber, day, time));
                            } else if (roomNumber.startsWith("5")) {
                                roomData_5f.add(new RoomItem(roomName, roomNumber, day, time));
                            }
                        }
                    }


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // 나머지 층도 동일한 방식으로 데이터 추가

        // 데이터 변경사항 알리는 코드
        adapter_1f.notifyDataSetChanged();
        adapter_2f.notifyDataSetChanged();
        adapter_3f.notifyDataSetChanged();
        adapter_4f.notifyDataSetChanged();
        adapter_5f.notifyDataSetChanged();

        // 나머지 어댑터에 대해서도 notifyDataSetChanged() 호출
    }

    public boolean isWithinRange(String currentTime, String time) throws ParseException {

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentTimeObj = timeFormat.parse(currentTime);

        String startT = "";
        String endT = "";

        if (time.equals("1")){
            startT = "09:00";
            endT = "10:00";
        }else if (time.equals("2")){
            startT = "10:00";
            endT = "11:00";
        }else if (time.equals("3")){
            startT = "11:00";
            endT = "12:00";
        }else if (time.equals("4")){
            startT = "12:00";
            endT = "13:00";
        }else if (time.equals("5")){
            startT = "13:00";
            endT = "14:00";
        }else if (time.equals("6")){
            startT = "14:00";
            endT = "15:00";
        }else if (time.equals("7")){
            startT = "15:00";
            endT = "16:00";
        }else if (time.equals("8")){
            startT = "16:00";
            endT = "17:00";
        }else if (time.equals("9")){
            startT = "17:00";
            endT = "18:00";
        }else if (time.equals("A")){
            startT = "09:30";
            endT = "10:45";
        }else if (time.equals("B")){
            startT = "11:00";
            endT = "12:15";
        }else if (time.equals("C")){
            startT = "13:00";
            endT = "14:15";
        }else if (time.equals("D")){
            startT = "14:30";
            endT = "15:45";
        }else if (time.equals("E")){
            startT = "16:00";
            endT = "17:15";
        }

        Date startTimeObj = timeFormat.parse(startT);
        Date endTimeObj = timeFormat.parse(endT);

        return currentTimeObj.after(startTimeObj) && currentTimeObj.before(endTimeObj);

    }

    private int getDayOfWeek(String day) {
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



    @Override
    public void onStart() {
        super.onStart();

    }
}
