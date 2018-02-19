package com.java8.date;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class ZoneTest {

    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        System.out.println(zoneId.getRules());

        LocalTime now1 = LocalTime.now();
        LocalTime now2 = LocalTime.now();

        System.out.println(now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

//        LocalDateTime localDateTime = LocalDateTime.of
    }

}
