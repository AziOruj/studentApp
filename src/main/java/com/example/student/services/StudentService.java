package com.example.student.services;

import com.example.student.dto.CreateStudent;
import com.example.student.dto.StudentDto;


public interface StudentService {
  StudentDto createStu(CreateStudent createStudent);
  StudentDto updateStu(CreateStudent createStudent, Long id);
  void deleteStu(Long id);
  StudentDto getStudent(Long id);

}
