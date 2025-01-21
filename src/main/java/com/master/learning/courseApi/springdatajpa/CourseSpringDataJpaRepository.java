package com.master.learning.courseApi.springdatajpa;

import com.master.learning.courseApi.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<CourseModel,Long> {
    List<CourseModel> findByAuthor(String author);
    List<CourseModel> findByName(String name);
}
