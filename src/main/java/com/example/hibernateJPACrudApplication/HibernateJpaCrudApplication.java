package com.example.hibernateJPACrudApplication;

import com.example.hibernateJPACrudApplication.dao.StudentDAO;
import com.example.hibernateJPACrudApplication.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudApplication.class, args);
	}

	// @Bean method will make an object to be managed by spring ioc container
	@Bean
	// commandlineRunner will execute the code after all beans and application context got loaded
	// Use case : Startup code
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createMultipleStudents(studentDAO);
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			//findAllStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("John", "Doe", "johndoe@gmail.com");
		studentDAO.save(student);
		System.out.println("Student is created with id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Paki", "Doe", "pakhidoe@gmail.com");
		Student student2 = new Student("Maki", "Poe", "makhiPoe@gmail.com");
		Student student3 = new Student("Zaki", "Koe", "zakhiKoe@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Student is created with id: " + student1.getId());
		System.out.println("Student is created with id: " + student2.getId());
		System.out.println("Student is created with id: " + student3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		System.out.println("Found student with id 1: " + student);
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void findAllStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("Mikki");
		studentDAO.update(student);
		System.out.println("Student is updated" + student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(3);
		System.out.println("Student is deleted");
 	}

	 private void deleteAllStudent(StudentDAO studentDAO) {
		int count = studentDAO.deleteAll();
		System.out.println(count + " number of students deleted ");
	 }
}
