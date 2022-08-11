package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseCategoryDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;
import org.mapstruct.Mapper;

@Mapper
public interface CourseCategoryMapper {

    CourseCategoryDTO map(CourseCategory category);
    CourseCategory map(CourseCategoryDTO categoryDTO);

}
