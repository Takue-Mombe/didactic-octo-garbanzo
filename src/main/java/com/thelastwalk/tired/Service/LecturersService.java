package com.thelastwalk.tired.Service;

import com.thelastwalk.tired.Models.Lecturers;
import com.thelastwalk.tired.Repositories.LecturersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LecturersService {

    @Autowired
    private LecturersRepository lecturersRepository;

    // Create operation
    public Lecturers createLecturer(Lecturers lecturer) {
        return lecturersRepository.save(lecturer);
    }
    // Read operation
    public List<Lecturers> getAllLecturers() {
        return lecturersRepository.findAll();
    }

    public Optional<Lecturers> getLecturerById(Long id) {
        return lecturersRepository.findById(id);
    }

    // Update operation
    public Lecturers updateLecturer(Long id, Lecturers newLecturer) {
        return lecturersRepository.findById(id)
                .map(lecturer -> {
                    lecturer.setLecture_number(newLecturer.getLecture_number());
                    lecturer.setFirst_name(newLecturer.getFirst_name());
                    lecturer.setLast_name(newLecturer.getLast_name());
                    return lecturersRepository.save(lecturer);
                })
                .orElse(null);
    }

    // Delete operation
    public void deleteLecturer(Long id) {
        lecturersRepository.deleteById(id);
    }
}
