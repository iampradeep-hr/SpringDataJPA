package com.pradeep.demo.repository;

import com.pradeep.demo.entity.Course;
import com.pradeep.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){

        Course course1=Course
                .builder()
                .title("GTO")
                .credit(4)
                .build();

        Course course2=Course
                .builder()
                .title("OS")
                .credit(6)
                .build();


        Teacher teacher=Teacher.builder()
                .firstName("Gucci")
                .lastName("man")
//                .courses(List.of(course1,course2))
                .build();


        Teacher t1=teacherRepository.save(teacher);

        System.out.println(t1);


    }

}