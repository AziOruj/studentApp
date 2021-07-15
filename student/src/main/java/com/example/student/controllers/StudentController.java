package com.example.student.controllers;

import com.example.student.dto.CreateStudent;
import com.example.student.dto.StudentDto;
import com.example.student.exception.StudentNotFound;
import com.example.student.services.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students/")
@Slf4j
@RequiredArgsConstructor
public class StudentController {
  private final StudentServiceImpl studentService;

  @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id){
      log.info("Get student by id {} ",id);
    try {
      return ResponseEntity.ok(studentService.getStudent(id));
    }catch (StudentNotFound studentNotFound) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
  }
  @PostMapping
    public StudentDto createStudent(@RequestBody CreateStudent createStudent){
      log.info("Create student {}",createStudent);
      return studentService.createStu(createStudent);
  }
  @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody CreateStudent createStudent){
      log.info("Update student by id {}, by student {}",id,createStudent);
    try {
      return ResponseEntity.ok(studentService.updateStu(createStudent,id));
    }catch (StudentNotFound e){
      return  ResponseEntity.notFound().build();
    }
  }
  @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id){
    try {
      studentService.deleteStu(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }catch (StudentNotFound e){
      return ResponseEntity.notFound().build();
    }
  }
}
