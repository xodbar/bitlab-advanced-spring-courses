package kz.xodbar.bitlabadvancedspringcoursesproject.api.rest;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.CourseMapper;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper.CourseMapperImpl;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper courseMapper() {
        return new CourseMapperImpl();
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        List<CourseDTO> courses = courseMapper().map(courseService.getAllCourses());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CourseDTO> getCourse(@PathVariable("id") Long id) {
        CourseDTO course = courseMapper().map(courseService.getCourseById(id));
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
