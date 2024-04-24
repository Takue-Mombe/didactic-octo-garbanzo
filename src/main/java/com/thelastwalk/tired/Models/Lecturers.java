package com.thelastwalk.tired.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "lecturers")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Lecturers {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long l_id;
    @Column(unique = true)
    private String lecture_number;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @ManyToMany(mappedBy = "lecturers")
    private List<Courses> courses = new ArrayList<>();
}
