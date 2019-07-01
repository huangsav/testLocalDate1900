package com.example.demo.controller;

import com.example.demo.mapper.TestDateMapper;
import com.example.demo.model.TestDate;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestDateController {

    @Resource
    private TestDateMapper testDateMapper;

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @GetMapping("/date")
    public void insertTest() {
        TestDate testDate = new TestDate();

        testDate.setId(30L);
        testDate.setTestDate(LocalDate.of(1900, 1,24));
        testDate.setTestDateTime(LocalDateTime.of(1900, 1,24,0,0,0));

        testDateMapper.insert(testDate);

    }

    @GetMapping("/testJdbc")
    public void testJdbc(){
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("id", 26);
        paraMap.put("test_date", LocalDate.of(1900, 1,23));
        paraMap.put("test_date_time", LocalDateTime.of(1900, 1,23,0,0,0));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(1900,1,22);
        System.out.println(simpleDateFormat.format(c.getTime()));
        namedParameterJdbcTemplate.update("INSERT INTO test_date values(:id,:test_date,:test_date_time)", paraMap);
    }
}
