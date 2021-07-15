package com.example.student;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import liquibase.pro.packaged.S;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class  StudentApplication implements CommandLineRunner {
	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		log.info("Insert data");
//		Student student = new Student();
//		student.setName("Azer");
//		student.setSureName("Orujov");
//		student.setAge(27);
//		student.setCity("Baku");
//		studentRepository.save(student);

	}
}
