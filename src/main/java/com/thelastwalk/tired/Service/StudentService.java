package com.thelastwalk.tired.Service;

import com.thelastwalk.tired.Models.Students;
import com.thelastwalk.tired.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Students saveStudent(Students students) {
        return studentRepository.save(students);
    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Students> getCourseById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteCourse(Long id) {
        studentRepository.deleteById(id);
    }
}
