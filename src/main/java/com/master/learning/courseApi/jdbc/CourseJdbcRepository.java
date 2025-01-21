package com.master.learning.courseApi.jdbc;

import com.master.learning.courseApi.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =

            """
                insert into course (id, name, author)
                values(?, ?,?);
    
            """;

    private static String DELETE_QUERY =

            """
                delete from course
                where id = ?
    
            """;

    private static String SELECT_QUERY =

            """
                select * from course
                where id = ?
    
            """;

    public void insert(CourseModel course) {
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public CourseModel findById(long id) {
        //ResultSet -> Bean => Row Mapper =>
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(CourseModel.class), id);

    }
}
