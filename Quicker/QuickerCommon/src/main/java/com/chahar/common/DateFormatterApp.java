package com.chahar.common;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatterApp {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 0);

        String pattern = "MMMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, i);
            String date = simpleDateFormat.format(cal.getTime());

            System.out.println(date + " -- " + new DateTime(cal.getTime()).getYearOfCentury());
        }

    }
}
