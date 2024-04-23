package com.thelastwalk.tired.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "program")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long program_Id;
    @Column(unique = true)
    private String program_Code;
    @Column
    private String program_name;
    @OneToMany(mappedBy = "program")
    private List<Students> students = new ArrayList<>();
    @OneToMany(mappedBy = "program")
    private List<Semester> semester = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "program_course",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> courses = new ArrayList<>();

    public int getSemesterCount() {
        return semester.size();
    }
}
