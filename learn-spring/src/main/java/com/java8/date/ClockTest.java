package com.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class ClockTest {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }

}
