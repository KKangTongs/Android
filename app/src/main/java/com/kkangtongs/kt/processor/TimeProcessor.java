package com.kkangtongs.kt.processor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeProcessor {

    public static String time;

    public static String getTime() {
        // 현재 시간 세팅
        LocalTime now = LocalTime.now();

        // 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 포맷 적용하기
        String formatedNow = now.format(formatter);

        // 시, 분, 초 구하기
        int hour = now.getHour();
        int minute = now.getMinute();

        time = String.format("%02d:%02d", hour, minute);

        return time;
    }

    public static void setTime(String newTime) {
        time = newTime;
    }

}
