package com.kkangtongs.kt.processor;

import android.content.Context;

import com.kkangtongs.kt.data.RoomItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RoomItemProcessor {

    public static ArrayList<JSONArray> gachon_gwan = new ArrayList<>(); // 가천관
    public static ArrayList<JSONArray> AI_gwan = new ArrayList<>();  // AI관
    public static ArrayList<JSONArray> vision_tower = new ArrayList<>();  // 비전타워
    public static ArrayList<JSONArray> bio_yeongu = new ArrayList<>();  // 바이오나노연구
    public static ArrayList<JSONArray> bio_nano_dae = new ArrayList<>();  // 바이오나노대학
    public static ArrayList<JSONArray> sanhak_hyeop2 = new ArrayList<>();  // 산학협력관2
    public static ArrayList<JSONArray> sanhak_hyeop = new ArrayList<>();  // 산학협력관
    public static ArrayList<JSONArray> gyoyook_daehakwon = new ArrayList<>();  // 교육대학원
    public static ArrayList<JSONArray> gongghwa2 = new ArrayList<>();  // 공과대학2
    public static ArrayList<JSONArray> gongghwa1 = new ArrayList<>();  // 공과대학1
    public static ArrayList<JSONArray> yesul2 = new ArrayList<>();  // 예술대학2
    public static ArrayList<JSONArray> yesul1 = new ArrayList<>();  // 예술대학1
    public static ArrayList<JSONArray> global_center = new ArrayList<>();  // 글로벌센터
    public static ArrayList<JSONArray> hanuigwa = new ArrayList<>(); // 한의과대학

    public static ArrayList<RoomItem> roomNameToRoomArray(Context context, String roomName) {


        try {

            ArrayList<RoomItem> result = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(context, "gachon_timetable.json")); // jsonString은 주어진 JSON 문자열입니다.

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray innerArray = jsonArray.getJSONArray(i);
                String value = innerArray.getString(6); // 8번째 인덱스 값 가져오기 (인덱스는 0부터 시작하므로 7을 사용)

                if (value.contains("가천관")) {
                    gachon_gwan.add(innerArray);
                }
                if (value.contains("AI")) {
                    AI_gwan.add(innerArray);
                }
                if (value.contains("비전타워")) {
                    vision_tower.add(innerArray);
                }
                if (value.contains("바이오나노연구")) {
                    bio_yeongu.add(innerArray);
                }
                if (value.contains("바이오나노대학")) {
                    bio_nano_dae.add(innerArray);
                }
                if (value.contains("산학협력관2")) {
                    sanhak_hyeop2.add(innerArray);
                }
                if (value.contains("산학협력관-")) {
                    sanhak_hyeop.add(innerArray);
                }
                if (value.contains("교육대학원")) {
                    gyoyook_daehakwon.add(innerArray);
                }
                if (value.contains("공과대학2")) {
                    gongghwa2.add(innerArray);
                }
                if (value.contains("공과대학1")) {
                    gongghwa1.add(innerArray);
                }
                if (value.contains("예술대학2")) {
                    yesul2.add(innerArray);
                }
                if (value.contains("예술대학1")) {
                    yesul1.add(innerArray);
                }
                if (value.contains("글로벌센터")) {
                    global_center.add(innerArray);
                }
                if (value.contains("한의과대학")) {
                    hanuigwa.add(innerArray);
                }
            }


            if (roomName.equals("가천관")) {
                result = jsonArrToRoomitem(gachon_gwan);
            }
            if (roomName.equals("AI관")) {
                result = jsonArrToRoomitem(AI_gwan);
            }
            if (roomName.equals("비전타워")) {
                result = jsonArrToRoomitem(vision_tower);
            }
            if (roomName.equals("바이오나노연구")) {
                result = jsonArrToRoomitem(bio_yeongu);
            }
            if (roomName.equals("바이오나노대학")) {
                result = jsonArrToRoomitem(bio_nano_dae);
            }
            if (roomName.equals("산학협력관2")) {
                result = jsonArrToRoomitem(sanhak_hyeop2);
            }
            if (roomName.equals("산학협력관")) {
                result = jsonArrToRoomitem(sanhak_hyeop);
            }
            if (roomName.equals("교육대학원")) {
                result = jsonArrToRoomitem(gyoyook_daehakwon);
            }
            if (roomName.equals("공과대학2")) {
                result = jsonArrToRoomitem(gongghwa2);
            }
            if (roomName.equals("공과대학1")) {
                result = jsonArrToRoomitem(gongghwa1);
            }
            if (roomName.equals("예술대학2")) {
                result = jsonArrToRoomitem(yesul2);
            }
            if (roomName.equals("예술대학1")) {
                result = jsonArrToRoomitem(yesul1);
            }
            if (roomName.equals("글로벌센터")) {
                result = jsonArrToRoomitem(global_center);
            }
            if (roomName.equals("한의과대학")) {
                result = jsonArrToRoomitem(hanuigwa);
            }

            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<RoomItem> jsonArrToRoomitem(ArrayList<JSONArray> buildingname){
        ArrayList<RoomItem> result = new ArrayList<>();
        for (JSONArray innerArray : buildingname) {
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
                    String dayTime2 = dayTimePart[1];
                    String dayTime3 = null;
                    if (dayTimePart.length != 2)
                        dayTime3 = dayTimePart[2];

                    String day1 = dayTime1.substring(0, 1); // 수
                    String time1 = dayTime1.substring(1); // 1

                    String day2 = dayTime2.substring(0, 1);
                    String time2 = dayTime2.substring(1);

                    String day3 = null;
                    String time3 = null;

                    if (dayTimePart.length == 3) {
                        day3 = dayTime3.substring(0, 1);
                        time3 = dayTime3.substring(1);
                    }

                    result.add(new RoomItem(roomName1, roomNumber1, day1, time1));

                    if (day1.equals(day2)){
                        result.add(new RoomItem(roomName1, roomNumber1, day2, time2));
                    } else {
                        result.add(new RoomItem(roomName2, roomNumber2, day2, time2));
                    }
                    if (dayTimePart.length == 3)
                        result.add(new RoomItem(roomName2, roomNumber2, day3, time3));

                } else { // 강의실 1개

                    String[] roomParts = roomNameNumber.split("-");
                    String[] dayTimePart = roomDayTime.split(" ,");

                    String roomName = roomParts[0];
                    String roomNumber = roomParts[1];

                    for (String dayTime : dayTimePart){
                        String day = dayTime.substring(0,1);
                        String time = dayTime.substring(1);

                        result.add(new RoomItem(roomName, roomNumber, day, time));
                    }

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    private static String loadJSONFromAsset(Context context, String filename) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
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
