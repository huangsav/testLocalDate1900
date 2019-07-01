package com.example.demo.mapper;

import com.example.demo.model.TestDate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDateMapper {

    @Insert ("INSERT INTO test_date (id, test_date, test_date_time) values(#{id}, #{testDate}, #{testDateTime})")
    void insert(TestDate testDate);
}
