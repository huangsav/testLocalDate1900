package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

import com.mysql.cj.util.TimeUtil;

public class TestCase {

    @Test
    public void test() throws ParseException {
        LocalDate localDate = LocalDate.of(1901, 1, 24);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);

        SimpleDateFormat sdf = new SimpleDateFormat("''yyyy-MM-dd''", Locale.US);
        TimeZone tz = TimeZone.getDefault();
//        sdf.setCalendar(tz);
        sdf.setTimeZone(tz);

        System.err.println(sdf.format(date));

        String pattern = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,Locale.US);
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        simpleDateFormat.setTimeZone(TimeZone.getDefault());

        String formatResult = simpleDateFormat.format(date);

        System.out.println(formatResult);

    }

}
