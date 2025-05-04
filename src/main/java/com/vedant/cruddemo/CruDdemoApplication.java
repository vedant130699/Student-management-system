package com.vedant.cruddemo;

import com.vedant.cruddemo.dao.StudentDAO;
import com.vedant.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruDdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruDdemoApplication.class, args);
    }


    @Bean
    //command line runner interface is part of spring
    public CommandLineRunner commandLineRunner(StudentDAO theStudentDAO) {
        return runner -> {
//            createStudent(theStudentDAO);
            createMultipleStudents(theStudentDAO);
//            readStudent(theStudentDAO);
//            queryforStudents(theStudentDAO);
//            queryForFindByLastName(theStudentDAO);
//            updateStudent(theStudentDAO);
//            deleteStudent(theStudentDAO);
//            deleteALlStudents(theStudentDAO);

        };
    }

    private void deleteALlStudents(StudentDAO theStudentDAO) {
        theStudentDAO.deleteAll();
        System.out.println("Deleted all students");
    }

    private void deleteStudent(StudentDAO theStudentDAO) {
        int id = 3;
        System.out.println("Deleting student " + id);
        theStudentDAO.delete(id);
    }

    private void updateStudent(StudentDAO theStudentDAO) {

        //retrieve student based on id: primary key
        int student_id = 1;
        System.out.println("Updating student " + student_id);
        Student student = theStudentDAO.findById(student_id);


        //change the first name to scooby
        System.out.println("Updating the student " + student);
        student.setFirstName("Vedant");


        //update the student
        theStudentDAO.update(student);


        //display the updated student
        System.out.println("Updated the student " + student);
    }

    private void queryForFindByLastName(StudentDAO theStudentDAO) {
        //get the list of students

        List<Student> theStudents = theStudentDAO.findByLastName("doe");


        //display the list
        for(Student theStudent: theStudents){
            System.out.println(theStudent);
        }
    }

    private void queryforStudents(StudentDAO theStudentDAO) {
        //get a list of students
        List<Student> theStudents = theStudentDAO.findall();

        //display the list
        for(Student student: theStudents){
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDao) {
        System.out.println("Creating a new object...");
        Student tempStudent = new Student("John", "Doe", "john.doe@gmail.com");

        studentDao.save(tempStudent);

        int thId = tempStudent.getId();
        tempStudent = studentDao.findById(thId);
        System.out.println("Retrieving student with id " + thId);
        System.out.println(tempStudent.toString());
    }

    private void createMultipleStudents(StudentDAO theStudentDAO) {
        //create multiple students
        System.out.println("Creating Student object..");
        Student theStudent1 = new Student("Vedant", "Kulkarni", "vedant.kulkarni@gmail.com");
        System.out.println("Creating Student object..");
        Student theStudent2 = new Student("john", "Doe", "John.Doe@gmail.com");

        System.out.println("Creating Student object..");
        Student theStudent3 = new Student("James", "Potter", "james.potter@gmail.com");

        //save student objects
        theStudentDAO.save(theStudent1);
        theStudentDAO.save(theStudent2);
        theStudentDAO.save(theStudent3);


    }

    private void createStudent(StudentDAO theStudentDAO) {
        //create a new student object
        System.out.println("Creating Student object..");
        Student theStudent = new Student("Vedant", "Kulkarni", "vedant.kulkarni@gmail.com");

        //save the student object
        theStudentDAO.save(theStudent);
        System.out.println("Saved Student object..");

        //display id of the saved object
        System.out.println("Saved student. Generated id: " + theStudent.getId());

    }
}

