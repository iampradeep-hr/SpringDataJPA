package com.pradeep.demo.repository;

import com.pradeep.demo.entity.Course;
import com.pradeep.demo.entity.Student;
import com.pradeep.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;



@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("courses: "+courses);
    }


    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Black")
                .lastName("Assassian")
                .build();
        Course course=Course
                .builder()
                .title("Intro to Python")
                .credit(4)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }


    //****** Paging and sorting *******

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords=
                PageRequest.of(0,3);


        Pageable firstPageWithTwoRecordsSorted=
                PageRequest.of(0,3, Sort.by("title").descending());
        List<Course> list= courseRepository
                        .findAll(firstPageWithTwoRecordsSorted)
                        .getContent();

        System.out.println(list);
    }

    //ManyToMany
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Dragon")
                .lastName("Warrior")
                .build();


        Student student=Student
                .builder()
                .firstName("Peter")
                .lastName("Parker")
                .emailId("spiderman@gmail.com")
                .build();

        Course course=Course
                .builder()
                .title("AI")
                .credit(6)
                .teacher(teacher)
                .build();


        course.addStudents(student);
        courseRepository.save(course);


    }


}