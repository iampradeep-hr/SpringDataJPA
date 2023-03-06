package com.pradeep.demo.repository;

import com.pradeep.demo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
