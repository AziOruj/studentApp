package com.example.student.dto;

import lombok.Data;

@Data
public class CreateStudent {
    private Long id;
    private String name;
    private String sureName;
    private Integer age;
}
