package com.example.demo.model;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TestDate implements Serializable {

    private Long id;

    private LocalDate testDate;

    private LocalDateTime testDateTime;
}
