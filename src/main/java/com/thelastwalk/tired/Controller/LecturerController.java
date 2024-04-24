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


}


