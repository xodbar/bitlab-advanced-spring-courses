package kz.xodbar.bitlabadvancedspringcoursesproject.service.impl;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.Course;
import kz.xodbar.bitlabadvancedspringcoursesproject.repository.CourseRepos;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseCategoryService;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseService;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepos courseRepository;

    @Autowired
    private CourseCategoryService courseCategoryService;

    @Autowired
    private UserService userService;

    @Override
    public Course addNewsCourse(String courseName,
                                String courseDescription,
                                int coursePrice,
                                double courseRating,
                                Long courseAuthorId,
                                String courseCategoryName) {

        Course newCourse = new Course();
        Long courseCategoryId = 0L;

        if (courseCategoryService.getCategoryByName(courseCategoryName) != null)
            courseCategoryId = courseCategoryService.getCategoryByName(courseCategoryName).getId();
        else courseCategoryId = courseCategoryService.addNewCategory(courseCategoryName).getId();

        return setCourseFields(courseName, courseDescription, coursePrice, courseRating, courseAuthorId, courseCategoryId, newCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Long courseId,
                               String courseName,
                               String courseDescription,
                               int coursePrice,
                               double courseRating,
                               Long courseAuthorId,
                               Long courseCategoryId) {

        if (getCourseById(courseId) == null)
            return null;

        Course course = getCourseById(courseId);
        return setCourseFields(courseName,
                courseDescription,
                coursePrice, courseRating,
                courseAuthorId,
                courseCategoryId,
                course);

    }

    private Course setCourseFields(String courseName,
                                   String courseDescription,
                                   int coursePrice,
                                   double courseRating,
                                   Long courseAuthorId,
                                   Long courseCategoryId,
                                   Course course) {

        course.setName(courseName);
        course.setDescription(courseDescription);
        course.setPrice(coursePrice);
        course.setRating(courseRating);
        course.setAuthor(userService.getUserById(courseAuthorId));
        course.setCategory(courseCategoryService.getCategoryById(courseCategoryId));

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
