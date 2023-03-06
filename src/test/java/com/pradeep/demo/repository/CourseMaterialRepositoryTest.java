package com.pradeep.demo.repository;

import com.pradeep.demo.entity.Course;
import com.pradeep.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course=Course.builder()
                .title("DSA")
                .credit(4)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.geeksforgeeks.com")
                .course(course)
                .build();


        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println("************Records***********\n"+courseMaterials);
    }


}