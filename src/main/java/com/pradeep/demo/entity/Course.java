package com.pradeep.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    //Bi directional mapping
    @OneToOne(
            mappedBy = "course",
            cascade = CascadeType.ALL
            //tells that there is already a mapping in courseMaterial already, use that
            //fk is already present there

    )
    private CourseMaterial courseMaterial;


    // ManyToOne relationship
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}
