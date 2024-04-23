package com.thelastwalk.tired.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="student")
@Getter@Setter
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;
    @Column(unique = true)
    private String reg_number;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column(unique = true)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs program;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> courses = new ArrayList<>();


}
