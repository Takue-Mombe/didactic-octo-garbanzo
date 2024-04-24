package com.thelastwalk.tired.Controller;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Programs;
import com.thelastwalk.tired.Models.Semester;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private ProgramService programService;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        List<Semester> semesters = semesterService.getAll();
        model.addAttribute("courses", courses);
        model.addAttribute("semesters", semesters);
        return "courselis";
    }
    @GetMapping("/listing")
    public String listCourses(Model model, @RequestParam(required = false) Long courseId) {
        List<Courses> courses = courseService.getAllCourses();
        List<Students> students;

        if(courseId != null) {
            students = studentService.getStudentsByCourseId(courseId); // Assuming you have a method to fetch students by courseId
        } else {
            students = studentService.getAllStudents();
        }

        model.addAttribute("courses", courses);
        model.addAttribute("filteredStudents", students);
        model.addAttribute("filterForm", new FilterForm(courseId)); // Create an instance of FilterForm and set courseId
        return "course-list";
    }







    @GetMapping("/add")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "courselis";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Courses course, BindingResult result,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "courselis";
        }
        courseService.saveCourse(course);
        redirectAttributes.addFlashAttribute("successMessage", "Course added successfully.");
        return "redirect:/courses/list";
    }

}

