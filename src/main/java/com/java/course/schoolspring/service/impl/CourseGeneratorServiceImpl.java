package com.java.course.schoolspring.service.impl;

import com.java.course.schoolspring.dao.CourseRepository;
import com.java.course.schoolspring.model.Course;
import com.java.course.schoolspring.service.CourseGeneratorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseGeneratorServiceImpl implements CourseGeneratorService {


    private final CourseRepository courseRepository;

    public CourseGeneratorServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    final String[] courseNames = {"Math", "Biology", "Physics", "Chemistry", "Computer Science", "Literature", "Art", "Music", "Economics", "History"};
    final String[] courseDescriptions = {"Mathematics course", "Biology course", "Physics course", "Chemistry course", "Computer Science course", "Literature course", "Art course", "Music course", "Economics course", "History course"};

    @Override
    public void generateCoursesIfNeed() {
        if (courseRepository.count() == 0) {
            List<Course> courses = new ArrayList<>();
            for (int i = 0; i < courseNames.length; i++) {
                Course course = new Course(courseNames[i], courseDescriptions[i]);
                courses.add(course);
            }
            courseRepository.saveAll(courses);
        }
    }
}
