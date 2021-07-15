package com.example.student.services;

import com.example.student.dto.CreateStudent;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.exception.StudentNotFound;
import com.example.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements  StudentService{
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public StudentDto createStu(CreateStudent createStudent) {
        log.info("Create new student {}",createStudent);
        StudentDto map = modelMapper.map(studentRepository.save(modelMapper.map(createStudent, Student.class)), StudentDto.class);
        return map;
    }

    @Override
    public StudentDto updateStu(CreateStudent createStudent, Long id) {
        log.info("Update by id {} student{}",id, createStudent);
        studentRepository.findById(id).orElseThrow(StudentNotFound::new);
        Student student =modelMapper.map(createStudent,Student.class);
        student.setId(id);
        studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStu(Long id) {
        log.info("Deleted by id {} student {}",id,studentRepository.findById(id));
        studentRepository.findById(id).orElseThrow(StudentNotFound::new);
        studentRepository.deleteById(id);

    }

    @Override
    public  StudentDto getStudent(Long id) {
        log.info("Get by id service {}",id);
        return modelMapper.map(studentRepository.findById(id)
                .orElseThrow(StudentNotFound::new), StudentDto.class);
    }
}
