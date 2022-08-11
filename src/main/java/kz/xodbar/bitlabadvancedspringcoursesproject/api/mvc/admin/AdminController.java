package kz.xodbar.bitlabadvancedspringcoursesproject.api.mvc.admin;

import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.CourseCategoryMapper;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.CourseMapper;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.UserMapper;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseCategoryService;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseService;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseCategoryService courseCategoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/")
    public String adminHomePanel(Model model) {
        model.addAttribute("courses", courseMapper.map(courseService.getAllCourses()));
        return "admin/admin_home";
    }

    @GetMapping("/addCourse")
    public String addCoursePage(Model model) {
        model.addAttribute("categories", courseCategoryService.getAllCategories());
        model.addAttribute("authors", userMapper.map(userService.getAllUsers()));

        return "admin/admin_add";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam("course_name") String courseName,
                            @RequestParam("course_rating") Double courseRating,
                            @RequestParam("course_price") Integer coursePrice,
                            @RequestParam("course_description") String courseDescription,
                            @RequestParam("course_author_id") Long courseAuthorId,
                            @RequestParam("course_category_name") String courseCategoryName) {

        courseService.addNewsCourse(
                courseName, courseDescription,
                coursePrice, courseRating,
                courseAuthorId, courseCategoryName
                );

        return "admin/admin_home";
    }

    @GetMapping("/{id}")
    public String editCoursePanel(@PathVariable("id") Long id,
                             Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "admin/admin_edit";
    }

    @PostMapping("/{id}")
    public String editCourse(@PathVariable("id") Long id,
                             @RequestParam("course_name") String courseName,
                             @RequestParam("course_description") String courseDescription,
                             @RequestParam("course_price") int coursePrice,
                             @RequestParam("course_rating") double courseRating,
                             @RequestParam("course_author_id") Long courseAuthorId,
                             @RequestParam("course_category_id") Long courseCategoryId) {

        courseService.updateCourse(
                id,
                courseName,
                courseDescription,
                coursePrice,
                courseRating,
                courseAuthorId,
                courseCategoryId
        );

        return "redirect:/api/admin/" + id;
    }

    @PostMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId) {
        courseService.deleteCourse(courseId);
        return "redirect:/api/admin/";
    }

}
