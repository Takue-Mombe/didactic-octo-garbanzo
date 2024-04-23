package com.thelastwalk.tired.Repositories;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Long> {
}
