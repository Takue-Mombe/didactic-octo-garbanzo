package com.thelastwalk.tired.Service;


import com.thelastwalk.tired.Models.Programs;
import com.thelastwalk.tired.Repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    public Programs saveProgram(Programs program) {
        return programRepository.save(program);
    }

    public List<Programs> getAllPrograms() {
        return programRepository.findAll();
    }

    public Programs getProgramById(Long id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Program not found with ID: " + id));
    }


    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
