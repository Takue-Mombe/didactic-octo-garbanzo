package com.thelastwalk.tired.Controller;

import com.thelastwalk.tired.Models.Semester;
import com.thelastwalk.tired.Service.ProgramService;
import com.thelastwalk.tired.Service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private ProgramService programService;

    @GetMapping("/list")
    public String listSemesters(Model model) {
        List<Semester> semesters = semesterService.getAll();
        model.addAttribute("semesters", semesters);
        return "semesterlist";
    }

    @GetMapping("/add")
    public String showAddSemesterForm(Model model) {
        model.addAttribute("semester", new Semester());
        model.addAttribute("programs", programService.getAllPrograms());
        return "semesterlist";
    }

    @PostMapping("/add")
    public String addSemester(@ModelAttribute("semester") Semester semester, BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "semesterlist";
        }
        semesterService.save(semester);
        redirectAttributes.addFlashAttribute("successMessage", "Semester added successfully.");
        return "redirect:/semesters/list";
    }

    // Add mappings for edit, delete, and other operations
}

