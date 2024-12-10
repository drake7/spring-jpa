package com.example.springboot3demo;

import com.example.springboot3demo.dao.AppDao;
import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Instructor;
import com.example.springboot3demo.entity.InstructorDetail;
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


	/*
	This code demonstrate how to use the entity manager with hibernate to run the CRUD operations
	@Bean

	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{

		return runner->{
	//			createStudent(studentDAO);
	//		System.out.println(readStudent(studentDAO));
	//		System.out.println(readStudentByLastName(studentDAO));
	//		updateStudent(studentDAO);
	//		deleteStudent(studentDAO);

			System.out.println("Application started");
		};

	}*/

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao)
	{

		return runner->{
			System.out.println("Application started");
		//	createInstructor(appDao);
		//	findInstructorById(appDao);
			findInstructorDetailById(appDao);
		};

	}

	private void findInstructorDetailById(AppDao appDao) {
		int id = 1;
		//check the whole functionality to learn how we found instructor details from the OnetoOne
		//bi directional mapping
		InstructorDetail insturctorDetail = appDao.findInstructorDetailById(id);
		System.out.println(insturctorDetail);

	}

	private void findInstructorById(AppDao appDao) {

		Instructor ins = appDao.findInstructorById(1);
		System.out.println(ins);
	}

	private void createInstructor(AppDao appDao) {

		Instructor instructor = new Instructor("Deepak","kumar","deepak.kumar7v@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("codeHub","codehub");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor:" + instructor);
		appDao.save(instructor);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.deleteStudent(13);
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

