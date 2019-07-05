package com.chahar.common;

import org.joda.time.DateTime;

import java.util.Calendar;

public class JodaTimeApp {
    public static void main(String[] args) {
        DateTime dateTime = DateTime.now();

        System.out.println(dateTime.getYearOfCentury());
        //System.out.println(dateTime.getYear());

        System.out.println(dateTime.getZone());


        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.MONTH));

    }
}
