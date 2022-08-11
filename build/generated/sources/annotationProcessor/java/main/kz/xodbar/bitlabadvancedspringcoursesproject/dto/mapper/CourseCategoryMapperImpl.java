package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import javax.annotation.processing.Generated;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseCategoryDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T17:49:49+0600",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
public class CourseCategoryMapperImpl implements CourseCategoryMapper {

    @Override
    public CourseCategoryDTO map(CourseCategory category) {
        if ( category == null ) {
            return null;
        }

        CourseCategoryDTO courseCategoryDTO = new CourseCategoryDTO();

        courseCategoryDTO.setId( category.getId() );
        courseCategoryDTO.setName( category.getName() );

        return courseCategoryDTO;
    }

    @Override
    public CourseCategory map(CourseCategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CourseCategory courseCategory = new CourseCategory();

        courseCategory.setId( categoryDTO.getId() );
        courseCategory.setName( categoryDTO.getName() );

        return courseCategory;
    }
}
