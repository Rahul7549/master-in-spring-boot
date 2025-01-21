package com.master.learning.courseApi.jpa;


import com.master.learning.courseApi.CourseModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(CourseModel course) {
        entityManager.merge(course);
    }

    public CourseModel findById(long id) {
        return entityManager.find(CourseModel.class, id);
    }

    public void deleteById(long id) {
        CourseModel course = entityManager.find(CourseModel.class, id);
        entityManager.remove(course);
    }
}
