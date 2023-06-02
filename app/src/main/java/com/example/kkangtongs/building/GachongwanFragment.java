package com.example.kkangtongs.building;

import static java.lang.Integer.parseInt;

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
import com.example.kkangtongs.processor.RoomItemProcessor;
import com.example.kkangtongs.processor.TimeProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GachongwanFragment extends Fragment {

    ImageView arrow_b2, arrow_b1, arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f, arrow_6f, arrow_7f, arrow_8f, arrow_9f;
    RecyclerView roomList_b2, roomList_b1, roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f, roomList_6f, roomList_7f, roomList_8f, roomList_9f;
    RecyclerView.Adapter adapter_b2, adapter_b1, adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f, adapter_6f, adapter_7f, adapter_8f, adapter_9f;

    ArrayList<RoomItem> roomData_b2 = new ArrayList<>();
    ArrayList<RoomItem> roomData_b1 = new ArrayList<>();
    ArrayList<RoomItem> roomData_1f = new ArrayList<>();
    ArrayList<RoomItem> roomData_2f = new ArrayList<>();
    ArrayList<RoomItem> roomData_3f = new ArrayList<>();
    ArrayList<RoomItem> roomData_4f = new ArrayList<>();
    ArrayList<RoomItem> roomData_5f = new ArrayList<>();
    ArrayList<RoomItem> roomData_6f = new ArrayList<>();
    ArrayList<RoomItem> roomData_7f = new ArrayList<>();
    ArrayList<RoomItem> roomData_8f = new ArrayList<>();
    ArrayList<RoomItem> roomData_9f = new ArrayList<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    public String currentTime = dateFormat.format(new Date());
    String currentTime = TimeProcessor.getTime();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_gachongwan, container, false);

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // 층별 화살표
        arrow_b2 = (ImageView) rootView.findViewById(R.id.gachongwan_B2_iv);
        arrow_b1 = (ImageView) rootView.findViewById(R.id.gachongwan_B1_iv);
        arrow_1f = (ImageView) rootView.findViewById(R.id.gachongwan_1f_iv);
        arrow_2f = (ImageView) rootView.findViewById(R.id.gachongwan_2f_iv);
        arrow_3f = (ImageView) rootView.findViewById(R.id.gachongwan_3f_iv);
        arrow_4f = (ImageView) rootView.findViewById(R.id.gachongwan_4f_iv);
        arrow_5f = (ImageView) rootView.findViewById(R.id.gachongwan_5f_iv);
        arrow_6f = (ImageView) rootView.findViewById(R.id.gachongwan_6f_iv);
        arrow_7f = (ImageView) rootView.findViewById(R.id.gachongwan_7f_iv);
        arrow_8f = (ImageView) rootView.findViewById(R.id.gachongwan_8f_iv);
        arrow_9f = (ImageView) rootView.findViewById(R.id.gachongwan_9f_iv);

        // 층별 강의실 정보
        roomList_b2 = (RecyclerView) rootView.findViewById(R.id.gachongwan_B2_rv);
        roomList_b1 = (RecyclerView) rootView.findViewById(R.id.gachongwan_B1_rv);
        roomList_1f = (RecyclerView) rootView.findViewById(R.id.gachongwan_1f_rv);
        roomList_2f = (RecyclerView) rootView.findViewById(R.id.gachongwan_2f_rv);
        roomList_3f = (RecyclerView) rootView.findViewById(R.id.gachongwan_3f_rv);
        roomList_4f = (RecyclerView) rootView.findViewById(R.id.gachongwan_4f_rv);
        roomList_5f = (RecyclerView) rootView.findViewById(R.id.gachongwan_5f_rv);
        roomList_6f = (RecyclerView) rootView.findViewById(R.id.gachongwan_6f_rv);
        roomList_7f = (RecyclerView) rootView.findViewById(R.id.gachongwan_7f_rv);
        roomList_8f = (RecyclerView) rootView.findViewById(R.id.gachongwan_8f_rv);
        roomList_9f = (RecyclerView) rootView.findViewById(R.id.gachongwan_9f_rv);

        // RecyclerView & Adapter 관련 코드
        initRecyclerView();

        ArrayList<RoomItem> gachon_gwan = RoomItemProcessor.roomNameToRoomArray(getContext(), "가천관");

        for(RoomItem roomItem : gachon_gwan) {
            if (!roomItem.getBuildingName().equals("가천관")){
                continue;
            }
            if (currentDayOfWeek != getDayOfWeek(roomItem.getDay())) { // 오늘 수업 아닌 경우
                boolean included = false;

                for (RoomItem rd : roomData_1f){ // 이미 데이터 있으면 break
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_2f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_3f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_4f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_5f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_6f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_7f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_8f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_9f){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_b1){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
                for (RoomItem rd : roomData_b2){
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }

                if (!included){

                    roomItem.setRemainTime(9999);
                    if (roomItem.getRoomNumber().startsWith("1")){
                        roomData_1f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("2")){
                        roomData_2f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("3")){
                        roomData_3f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("4")){
                        roomData_4f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("5")){
                        roomData_5f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("6")){
                        roomData_6f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("7")){
                        roomData_7f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("8")){
                        roomData_8f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("9")){
                        roomData_9f.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("B1")){
                        roomData_b1.add(roomItem);
                    }else if(roomItem.getRoomNumber().startsWith("B2")){
                        roomData_b2.add(roomItem);
                    }

                }


            }
        }

        for(RoomItem roomItem : gachon_gwan) {
            if (!roomItem.getBuildingName().equals("가천관")){
                continue;
            }
            try {
                if (currentDayOfWeek == getDayOfWeek(roomItem.getDay())) {
                    if (roomItem.isInclass() || roomItem.getTime().equals("")) { // 수업 중이거나 시간 없는 수업이면 continue
                        continue;
                    }
                    if (isWithinRange(currentTime, roomItem.getTime()) || isAfterRange(currentTime, roomItem.getTime())) { // 현재 수업중
                        roomItem.setInclass(true);
                    } else {
                        boolean included = false;

                        for (RoomItem rd : roomData_1f) {// 이미 1층에 있는 경우
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_2f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_3f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_4f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_5f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_6f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_7f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_8f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_9f) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_b1) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_b2) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime())) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }

                        if (included) {
                            continue;
                        }

                        roomItem.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));

                        if (roomItem.getRoomNumber().startsWith("1")) {
                            roomData_1f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("2")) {
                            roomData_2f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("3")) {
                            roomData_3f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("4")) {
                            roomData_4f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("5")) {
                            roomData_5f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("6")) {
                            roomData_6f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("7")) {
                            roomData_7f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("8")) {
                            roomData_8f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("9")) {
                            roomData_9f.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("B1")) {
                            roomData_b1.add(roomItem);
                        } else if (roomItem.getRoomNumber().startsWith("B2")) {
                            roomData_b2.add(roomItem);
                        }
                    }
                }

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }


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

        arrow_7f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_7f.getVisibility() == View.GONE) {
                    roomList_7f.setVisibility(View.VISIBLE);
                    arrow_7f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_7f.setVisibility(View.GONE);
                    arrow_7f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        arrow_8f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_8f.getVisibility() == View.GONE) {
                    roomList_8f.setVisibility(View.VISIBLE);
                    arrow_8f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_8f.setVisibility(View.GONE);
                    arrow_8f.animate().setDuration(200).rotation(0f);
                }
            }
        });

        arrow_9f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomList_9f.getVisibility() == View.GONE) {
                    roomList_9f.setVisibility(View.VISIBLE);
                    arrow_9f.animate().setDuration(200).rotation(180f);
                }
                else {
                    roomList_9f.setVisibility(View.GONE);
                    arrow_9f.animate().setDuration(200).rotation(0f);
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
        adapter_7f = new RoomListRVAdapter(roomData_7f);
        adapter_8f = new RoomListRVAdapter(roomData_8f);
        adapter_9f = new RoomListRVAdapter(roomData_9f);

        // RecyclerView의 LayoutManager 설정
        roomList_b2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_b1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_1f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_2f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_3f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_4f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_5f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_6f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_7f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_8f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_9f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // 층별 RecyclerView와 Adapter 연결
        roomList_b2.setAdapter(adapter_b2);
        roomList_b1.setAdapter(adapter_b1);
        roomList_1f.setAdapter(adapter_1f);
        roomList_2f.setAdapter(adapter_2f);
        roomList_3f.setAdapter(adapter_3f);
        roomList_4f.setAdapter(adapter_4f);
        roomList_5f.setAdapter(adapter_5f);
        roomList_6f.setAdapter(adapter_6f);
        roomList_7f.setAdapter(adapter_7f);
        roomList_8f.setAdapter(adapter_8f);
        roomList_9f.setAdapter(adapter_9f);
    }

    private boolean isAfterRange(String currentTime, String time) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentTimeObj = timeFormat.parse(currentTime);

        String startT = null;
        String endT = null;

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
        }else if (time.equals("10")){
            startT = "18:00";
            endT = "19:00";
        }else if (time.equals("11")){
            startT = "19:00";
            endT = "20:00";
        }else if (time.equals("12")){
            startT = "20:00";
            endT = "21:00";
        }else if (time.equals("13")){
            startT = "21:00";
            endT = "22:00";
        }else if (time.equals("14")){
            startT = "22:00";
            endT = "23:00";
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

        return currentTimeObj.after(endTimeObj);
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

    public int getRemainTime (String currentTime, String time) throws ParseException {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentTimeObj = timeFormat.parse(currentTime);

        String startT = null;
        String endT = null;

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
        }else if (time.equals("10")){
            startT = "18:00";
            endT = "19:00";
        }else if (time.equals("11")){
            startT = "19:00";
            endT = "20:00";
        }else if (time.equals("12")){
            startT = "20:00";
            endT = "21:00";
        }else if (time.equals("13")){
            startT = "21:00";
            endT = "22:00";
        }else if (time.equals("14")){
            startT = "22:00";
            endT = "23:00";
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



        String crntParts[] = currentTime.split(":"); //
        String crntHour = crntParts[0];// 현재 시간
        String crntMinute = crntParts[1]; // 현재 분

        String stParts[] = startT.split(":"); //
        String stHour = stParts[0];// 강의 시작 시간
        String stMinute = stParts[1]; // 분

        int timeDifference = (parseInt(stHour) - parseInt(crntHour)) * 60 + parseInt(stMinute) - parseInt(crntMinute);

        return timeDifference;
    }

    public boolean isWithinRange(String currentTime, String time) throws ParseException {

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date currentTimeObj = timeFormat.parse(currentTime);

        String startT = null;
        String endT = null;

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
        }else if (time.equals("10")){
            startT = "18:00";
            endT = "19:00";
        }else if (time.equals("11")){
            startT = "19:00";
            endT = "20:00";
        }else if (time.equals("12")){
            startT = "20:00";
            endT = "21:00";
        }else if (time.equals("13")){
            startT = "21:00";
            endT = "22:00";
        }else if (time.equals("14")){
            startT = "22:00";
            endT = "23:00";
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

        return currentTimeObj.after(startTimeObj) && currentTimeObj.before(endTimeObj) || currentTimeObj.equals(endTimeObj);
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
        adapter_7f.notifyDataSetChanged();
        adapter_8f.notifyDataSetChanged();
        adapter_9f.notifyDataSetChanged();

    }
}
