package com.thelastwalk.tired.Repositories;

import com.thelastwalk.tired.Models.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturersRepository extends JpaRepository<Lecturers, Long> {

}


