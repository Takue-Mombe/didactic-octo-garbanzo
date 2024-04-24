package com.thelastwalk.tired.Repositories;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {
    List<Students> findByCoursesIn(List<Courses> courses);
}

