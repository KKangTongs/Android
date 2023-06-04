package com.example.kkangtongs.building;

import static java.lang.Integer.parseInt;

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

import com.example.kkangtongs.R;
import com.example.kkangtongs.main.LectureRoomFragment;
import com.example.kkangtongs.processor.RoomItemProcessor;
import com.example.kkangtongs.adapter.RoomListRVAdapter;
import com.example.kkangtongs.data.RoomItem;
import com.example.kkangtongs.processor.TimeProcessor;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BionanoFragment extends Fragment {

    ImageView arrow_b1, arrow_1f, arrow_2f, arrow_3f, arrow_4f, arrow_5f;
    RecyclerView roomList_b1, roomList_1f, roomList_2f, roomList_3f, roomList_4f, roomList_5f;
    RecyclerView.Adapter adapter_b1, adapter_1f, adapter_2f, adapter_3f, adapter_4f, adapter_5f;

    ArrayList<RoomItem> roomData_b1 = new ArrayList<>();
    ArrayList<RoomItem> roomData_1f = new ArrayList<>();
    ArrayList<RoomItem> roomData_2f = new ArrayList<>();
    ArrayList<RoomItem> roomData_3f = new ArrayList<>();
    ArrayList<RoomItem> roomData_4f = new ArrayList<>();
    ArrayList<RoomItem> roomData_5f = new ArrayList<>();

    ArrayList<RoomItem> bio_nano = new ArrayList<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//    public String currentTime = dateFormat.format(new Date());
    String currentTime;
    int currentDayOfWeek;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_bionano, container, false);

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        currentTime = TimeProcessor.getTime();

        // RoomItemProcessor 클래스를 사용하여 바이오나노대학 정보만 읽어오기
        bio_nano = RoomItemProcessor.roomNameToRoomArray(getContext(), "바이오나노대학");

        // 층별 화살표
        arrow_b1 = (ImageView) rootView.findViewById(R.id.bionano_B1_iv);
        arrow_1f = (ImageView) rootView.findViewById(R.id.bionano_1f_iv);
        arrow_2f = (ImageView) rootView.findViewById(R.id.bionano_2f_iv);
        arrow_3f = (ImageView) rootView.findViewById(R.id.bionano_3f_iv);
        arrow_4f = (ImageView) rootView.findViewById(R.id.bionano_4f_iv);
        arrow_5f = (ImageView) rootView.findViewById(R.id.bionano_5f_iv);

        // 층별 강의실 정보
        roomList_b1 = (RecyclerView) rootView.findViewById(R.id.bionano_B1_rv);
        roomList_1f = (RecyclerView) rootView.findViewById(R.id.bionano_1f_rv);
        roomList_2f = (RecyclerView) rootView.findViewById(R.id.bionano_2f_rv);
        roomList_3f = (RecyclerView) rootView.findViewById(R.id.bionano_3f_rv);
        roomList_4f = (RecyclerView) rootView.findViewById(R.id.bionano_4f_rv);
        roomList_5f = (RecyclerView) rootView.findViewById(R.id.bionano_5f_rv);

        // RecyclerView & Adapter 관련 코드
        initRecyclerView();

        // time에 대한 변화를 실시간으로 받는 코드
        try {
            EventBus.getDefault().register(this);
        }catch (Exception e) {
            e.printStackTrace();
        }

        // 설정된 시간에 따른 층별 강의실 정보 업데이트
        setRoomList(currentTime);


        // 층별 화살표에 대한 Click Listener
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

        return rootView;
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


    // RecyclerView 초기화 코드
    private void initRecyclerView() {

        // Adapter 선언과 데이터 넘겨주기
        adapter_b1 = new RoomListRVAdapter(roomData_b1);
        adapter_1f = new RoomListRVAdapter(roomData_1f);
        adapter_2f = new RoomListRVAdapter(roomData_2f);
        adapter_3f = new RoomListRVAdapter(roomData_3f);
        adapter_4f = new RoomListRVAdapter(roomData_4f);
        adapter_5f = new RoomListRVAdapter(roomData_5f);

        // RecyclerView의 LayoutManager 설정
        roomList_b1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_1f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_2f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_3f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_4f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        roomList_5f.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        // 층별 RecyclerView와 Adapter 연결
        roomList_b1.setAdapter(adapter_b1);
        roomList_1f.setAdapter(adapter_1f);
        roomList_2f.setAdapter(adapter_2f);
        roomList_3f.setAdapter(adapter_3f);
        roomList_4f.setAdapter(adapter_4f);
        roomList_5f.setAdapter(adapter_5f);
    }


    private void setRoomList(String currentTime) {

        for(RoomItem roomItem : bio_nano) {
            if (!roomItem.getBuildingName().equals("바이오나노대학")){
                continue;
            }
            if (currentDayOfWeek != getDayOfWeek(roomItem.getDay())) { // 오늘 수업 아닌 경우
                boolean included = false;


                for (RoomItem rd : roomData_b1){ // 이미 데이터 있으면 break
                    if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                        included = true;
                        break;
                    }
                }
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
                    }else if(roomItem.getRoomNumber().startsWith("B")){
                        roomData_b1.add(roomItem);
                    }
                }


            }
        }

        for(RoomItem roomItem : bio_nano) {
            if (!roomItem.getBuildingName().equals("바이오나노대학")){
                continue;
            }

            try {
                if (currentDayOfWeek == getDayOfWeek(roomItem.getDay())) {
                    if (isWithinRange(currentTime, roomItem.getTime())) { // 현재 수업중
                        roomItem.setInclass(true);

                        for (RoomItem rd : roomData_1f){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }
                        for (RoomItem rd : roomData_2f){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }
                        for (RoomItem rd : roomData_3f){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }
                        for (RoomItem rd : roomData_4f){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }
                        for (RoomItem rd : roomData_5f){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }
                        for (RoomItem rd : roomData_b1){
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())){
                                rd.setInclass(true);
                            }
                        }

                    } else if (!isAfterRange(currentTime, roomItem.getTime())){  // 수업시간 이전인 경우

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
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime()) && !rd.isInclass()) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }
                        for (RoomItem rd : roomData_b1) {
                            if (rd.getRoomNumber().equals(roomItem.getRoomNumber())) {
                                if (rd.getRemainTime() > getRemainTime(currentTime, roomItem.getTime()) && !rd.isInclass()) {
                                    rd.setRemainTime(getRemainTime(currentTime, roomItem.getTime()));
                                }
                                included = true;
                                break;
                            }
                        }

                        if (included || roomItem.isInclass()) {
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
                        } else if (roomItem.getRoomNumber().startsWith("B1")) {
                            roomData_b1.add(roomItem);
                        }
                    }
                }

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        // 데이터 변경사항 알리는 코드
        adapter_b1.notifyDataSetChanged();
        adapter_1f.notifyDataSetChanged();
        adapter_2f.notifyDataSetChanged();
        adapter_3f.notifyDataSetChanged();
        adapter_4f.notifyDataSetChanged();
        adapter_5f.notifyDataSetChanged();

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

    // LectureRoomFragment에서 시간 등록 이벤트가 발생했을때
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void testEvent(LectureRoomFragment.DataEvent event) {
        currentTime = event.time;
        clearList();
        setRoomList(currentTime);
        Log.d("EVENTTIME", currentTime);
    }

    public void clearList() {
        Log.d("CLEAR_TIME", "clearList()");

        bio_nano.clear();
        bio_nano = RoomItemProcessor.roomNameToRoomArray(getContext(), "바이오나노대학");

        roomData_b1.clear();
        roomData_1f.clear();
        roomData_2f.clear();
        roomData_3f.clear();
        roomData_4f.clear();
        roomData_5f.clear();
    }
}
