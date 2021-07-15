package com.example.student.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sureName;
    private Integer age;




}
