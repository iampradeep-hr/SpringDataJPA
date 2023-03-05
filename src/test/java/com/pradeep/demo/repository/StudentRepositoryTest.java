package com.pradeep.demo.repository;

import com.pradeep.demo.entities.Guardian;
import com.pradeep.demo.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("pradeep@gmail.com")
                .firstName("Pradeep")
                .lastName("HR")
//                .guardianEmail("lilpersian3@gmail.com")
//                .guardianName("Yoshi")
//                .guardianMobile("9999995555")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList=studentRepository.findAll();
        System.out.println(studentList);
    }


    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .email("lilpersian3@gmail.com")
                .name("Yoshi")
                .mobile("9999995555").build();


        Student student = Student.builder()
                .emailId("sohan@gmail.com")
                .firstName("Sohan")
                .lastName("S")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void printStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("Pradeep");

        System.out.println("*** Found Records ***\n"+studentList);
    }

    @Test
    public void printStudentByFirstNameContains(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("Prad");

        System.out.println("*** Found Records ***\n"+studentList);
    }


    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("Yoshi");

        System.out.println("*** Found Records ***\n"+studentList);
    }

}