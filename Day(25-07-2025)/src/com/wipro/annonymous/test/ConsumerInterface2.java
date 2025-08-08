package com.wipro.annonymous.test;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.function.Consumer;

public class ConsumerInterface2 {

    public static void main(String[] args) {
        Consumer<String> printTime = (zone) -> {
            ZonedDateTime zoneTime = ZonedDateTime.now(ZoneId.of(zone));
            System.out.println( zoneTime);
        };

        printTime.accept("Europe/London");
        
    }
}
