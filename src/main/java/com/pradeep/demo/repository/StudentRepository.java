package com.pradeep.demo.repository;

import com.pradeep.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);


    //************ Custom Queries [JPQL] ****************
    //jpql queries are based on class in app, not based on rows in db
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


    //SQL Native Queries
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);


    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParams(
            @Param("emailId")
            String emailId
    );


    //Modifying
    @Modifying //tells that data can is being modified
    @Transactional
    @Query(
            value = "update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);






}
