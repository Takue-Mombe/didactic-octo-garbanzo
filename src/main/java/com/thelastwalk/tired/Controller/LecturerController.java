package com.thelastwalk.tired.Controller;

import com.thelastwalk.tired.Models.Courses;
import com.thelastwalk.tired.Models.Lecturers;
import com.thelastwalk.tired.Models.Students;
import com.thelastwalk.tired.Service.CourseService;
import com.thelastwalk.tired.Service.LecturersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    @Autowired
    private LecturersService lecturersService;

    @Autowired
    private CourseService coursesService;

    @GetMapping("/dashboard")
    public String showDashboard(@RequestParam("lectureNumber") Long lectureNumber, Model model) {
        Optional<Lecturers> existingLecturer = lecturersService.getLecturerById(lectureNumber);
        if (existingLecturer.isPresent()) {
            Lecturers lecturer = existingLecturer.get();
            model.addAttribute("lecturer", lecturer);
            model.addAttribute("courses", lecturer.getCourses());
            return "lecturer_add";
        } else {
            model.addAttribute("errorMessage", "Lecturer not found. Please register.");
            return "error";
        }
    }
    @GetMapping("/add")
    public String showAddLecturerForm(Model model) {
        List<Courses> courses = coursesService.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("lecturer", new Lecturers());
        return "lecturer_add";
    }


    @PostMapping("/register")
    public String registerLecturer(@RequestParam("lectureNumber") Long lectureNumber, Model model) {
        Optional<Lecturers> existingLecturer = lecturersService.getLecturerById(lectureNumber);
        if (existingLecturer.isPresent()) {
            model.addAttribute("lecturer", existingLecturer.get());
        } else {
            model.addAttribute("errorMessage", "Lecturer not found. Please register.");
        }
        return "lecturer_add";
    }
    @PostMapping("/add")
    public String addLecturer(@ModelAttribute("lecturer") Lecturers lecturers, BindingResult result,
                             RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "error";
        }
        Lecturers savedLecturers=lecturersService.createLecturer(lecturers);
        System.out.println("Lecturer of Id: "+savedLecturers.getLecture_number()+" saved");
        redirectAttributes.addFlashAttribute("successMessage", "Student added successfully.");
        model.addAttribute("lecturers", lecturers);
        return "redirect:/lecturers/register";
    }

    @GetMapping("/view-courses")
    public String showLecturerCourses(@RequestParam("lecturerId") Long lecturerId, Model model) {
        Optional<Lecturers> lecturer = lecturersService.getLecturerById(lecturerId);
        if (lecturer.isPresent()) {
            model.addAttribute("lecturer", lecturer.get());
            model.addAttribute("courses", lecturer.get().getCourses());
        } else {
            // Handle lecturer not found scenario
            return "error";
        }
        return "lecturer_add";
    }

    // Assuming you have a method to get students by course ID in the CoursesService
    @GetMapping("/view-students")
    public String showStudentsByCourse(@RequestParam("courseId") Long courseId, Model model) {
        Optional<Courses> course = Optional.ofNullable(coursesService.getCourseById(courseId));
        if (course.isPresent()) {
            model.addAttribute("students", course.get().getStudents());
        } else {
            // Handle course not found scenario
            return "error";
        }
        return "lecturer_add";
    }
}


