package com.java_hibernate.cruddemo;

import com.java_hibernate.cruddemo.dao.StudentDao;
import com.java_hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
//			creteStudent(studentDao);
//			createMultipleStudent(studentDao);
//			readStudent(studentDao);
			queryForStudents(studentDao);
		};
	}

	private void queryForStudents(StudentDao studentDao) {
		//get a list of students
		List<Student> theStudents = studentDao.findall();

		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}



	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		System.out.println("Creating new Student object ...");
		Student tempStudnet1 = new Student("First Name4","Last Name 4","firstName4@email.com");


		//save the student
		System.out.println("Saving the student ...");
		studentDao.save(tempStudnet1);

		// display id of the save the student
		int theId = tempStudnet1.getId();
		System.out.println("Saved student.Generated id: "+theId);

		//retrieve student based on id : primary key
		System.out.println("Retriving student with id: "+ theId);
		Student myStudent = studentDao.findById(theId);

		//display student
		System.out.println("Found the student: "+myStudent);

	}

	private void createMultipleStudent(StudentDao studentDao) {
		//creat multiple student
		System.out.println("Creating 3 Student sobject ...");
		Student tempStudnet1 = new Student("First Name1","Last Name 1","firstName1@email.com");
		Student tempStudnet2 = new Student("First Name2","Last Name 2","firstName2@email.com");
		Student tempStudnet3 = new Student("First Name3","Last Name 3","firstName3@email.com");


		//save the students objects
		System.out.println("Saving the students ...");
		studentDao.save(tempStudnet1);
		studentDao.save(tempStudnet2);
		studentDao.save(tempStudnet3);





	}

	private void creteStudent(StudentDao studentDao) {
		// create the student object
		System.out.println("Creating new Student object ...");
		Student tempStudnet = new Student("First Name0","Last Name 0","firstName0@email.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDao.save(tempStudnet);

		//display id of the saved student
		System.out.println("Saved Student Generated id: ..."+tempStudnet.getId());
	}

}
