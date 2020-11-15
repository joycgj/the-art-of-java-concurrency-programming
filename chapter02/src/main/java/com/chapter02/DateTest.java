package com.chapter02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);

        System.out.println(sdf.format(date));

        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf1.parse(birth);
        System.out.println(date1);

        java.sql.Date birthDate = new java.sql.Date(date1.getTime());
        System.out.println(birthDate);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        Date date2 = calendar.getTime();
        System.out.println(date2);

        Date date3 = new Date();
        calendar.setTime(date3);
    }
}
