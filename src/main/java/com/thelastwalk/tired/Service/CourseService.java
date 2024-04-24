package com.thelastwalk.tired.Service;


import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Programs;
import com.thelastwalk.tired.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Courses saveCourse(Courses course) {
        return courseRepository.save(course);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }




    public Courses getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found with ID: " + courseId));
    }
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Courses> getCoursesByProgram(Programs program) {
        return courseRepository.findByPrograms(program);
    }
}
