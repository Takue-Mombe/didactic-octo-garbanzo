package com.thelastwalk.tired.Repositories;

import com.thelastwalk.tired.Models.Programs;
import com.thelastwalk.tired.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Programs,Long> {
}

