package com.thelastwalk.tired.Controller;

import com.thelastwalk.tired.Models.Students;
import com.thelastwalk.tired.Service.CourseService;
import com.thelastwalk.tired.Service.ProgramService;
import com.thelastwalk.tired.Service.SemesterService;
import com.thelastwalk.tired.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProgramService programService;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Students> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Students());
        model.addAttribute("programs", programService.getAllPrograms());
        model.addAttribute("semesters", semesterService.getAll());
        model.addAttribute("courses", courseService.getAllCourses());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Students student, BindingResult result,
                             RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "add-student";
        }
        Students savedStudents=studentService.saveStudent(student);
        System.out.println("Student of Id: "+savedStudents.getReg_number()+" saved");
        redirectAttributes.addFlashAttribute("successMessage", "Student added successfully.");
        model.addAttribute("student", student); // Add the student object to pass to the My Space page
        return "my-space";
    }



}

