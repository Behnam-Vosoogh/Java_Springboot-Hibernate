package com.java_hibernate.cruddemo;

import com.java_hibernate.cruddemo.dao.StudentDao;
import com.java_hibernate.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			creteStudent(studentDao);
		};
	}

	private void creteStudent(StudentDao studentDao) {
		// create the student object
		System.out.println("Creating new Student object ...");
		Student tempStudnet = new Student("First Name0","Last Name 0","firstName1@email.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDao.save(tempStudnet);

		//display id of the saved student
		System.out.println("Saved Student Generated id: ..."+tempStudnet.getId());
	}

}
