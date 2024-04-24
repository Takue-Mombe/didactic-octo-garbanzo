package com.thelastwalk.tired.Service;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Students;
import com.thelastwalk.tired.Repositories.CourseRepository;
import com.thelastwalk.tired.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Students saveStudent(Students students) {
        return studentRepository.save(students);
    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Students> getStudentsByCourse(List<Courses> courses) {
        return studentRepository.findByCoursesIn(courses);
    }

    public Optional<Students> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        studentRepository.deleteById(id);
    }


    public List<Students> getStudentsByCourseId(Long courseId) {
        Optional<Courses> courseOptional = courseRepository.findById(courseId);

        if (courseOptional.isPresent()) {
            Courses course = courseOptional.get();
            return course.getStudents();
        } else {
            return Collections.emptyList();
        }
    }
}
