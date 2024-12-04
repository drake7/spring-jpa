package com.example.springboot3demo;

import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Springboot3demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3demoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{

		return runner->{
	//			createStudent(studentDAO);
	//		System.out.println(readStudent(studentDAO));
	//		System.out.println(readStudentByLastName(studentDAO));
			updateStudent(studentDAO);
		};
	}

	private Student readStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object");
		Student tempStudent = new Student("Deepak","Doe","PaulDoe@gmail.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		System.out.println("Id of saved student");
		System.out.println(tempStudent.getId());

		return studentDAO.findById(tempStudent.getId());
	}
	private List<Student> readStudentByLastName(StudentDAO studentDAO) {

		return studentDAO.findByLastName("Doe");
	}
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul","Doe","PaulDoe@gmail.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		System.out.println("Id of saved student");
		System.out.println(tempStudent.getId());

		studentDAO.findById(tempStudent.getId());
	}

	private void updateStudent(StudentDAO studentDAO){

		System.out.println("Updates for the code");
		Student tempStudent = new Student("Paul","Doe","PaulDoe@gmail.com");
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		System.out.println("Id of saved student");
		System.out.println(tempStudent.getId());
		System.out.println("Update something in the student");
		tempStudent.setEmail("deepak.kumar7v@gmai.com");
		studentDAO.updateStudent(tempStudent);


	}
}

