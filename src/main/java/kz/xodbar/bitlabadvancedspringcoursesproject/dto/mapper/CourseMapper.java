package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CourseMapper extends CourseCategoryMapper {

    @Mapping(target = "priceValue", source = "price")
    @Mapping(target = "ratingValue", source = "rating")
    CourseDTO map(Course course);
    List<CourseDTO> map(List<Course> courses);

    @Mapping(source = "priceValue", target = "price")
    @Mapping(source = "ratingValue", target = "rating")
    Course map(CourseDTO courseDTO);

}
