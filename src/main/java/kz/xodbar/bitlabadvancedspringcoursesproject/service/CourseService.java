package kz.xodbar.bitlabadvancedspringcoursesproject.service;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.Course;
import org.springframework.web.bind.annotation.RequestParam;

public interface CourseService {

    Course addNewsCourse(String courseName,
                         String courseDescription,
                         int coursePrice,
                         double courseRating,
                         Long courseAuthorId,
                         String courseCategoryName);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    Course updateCourse(Long courseId,
                        String courseName,
                        String courseDescription,
                        int coursePrice,
                        double courseRating,
                        Long courseAuthorId,
                        Long courseCategoryId);
    void deleteCourse(Long id);

}
