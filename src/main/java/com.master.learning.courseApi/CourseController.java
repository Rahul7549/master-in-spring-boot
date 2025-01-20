package com.master.learning.courseApi;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/course")
    public List<CourseModel> fetchAllCourses(){
        return Arrays.asList(
                new CourseModel(1,"Java","in28min"),
                new CourseModel(2,"C#","in28min"),
                new CourseModel(2,"C#","in28min"),
                new CourseModel(2,"C#","in28min"),
                new CourseModel(2,"C#","in28min")
        );


    }
}