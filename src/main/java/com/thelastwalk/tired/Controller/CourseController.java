package com.thelastwalk.tired.Controller;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Semester;
import com.thelastwalk.tired.Service.CourseService;
import com.thelastwalk.tired.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private SemesterService semesterService;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Courses> courses = courseService.getAllCourses();
        List<Semester> semesters = semesterService.getAll();
        model.addAttribute("courses", courses);
        model.addAttribute("semesters", semesters);
        return "courselis";
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

    // Add mappings for edit, delete, and other operations
}

