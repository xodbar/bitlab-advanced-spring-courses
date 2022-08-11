package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseCategoryDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course.CourseDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.Course;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T17:14:30+0600",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
public class CourseMapperImpl implements CourseMapper {

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

    @Override
    public CourseDTO map(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setPriceValue( course.getPrice() );
        courseDTO.setRatingValue( course.getRating() );
        courseDTO.setId( course.getId() );
        courseDTO.setName( course.getName() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setCategory( map( course.getCategory() ) );

        return courseDTO;
    }

    @Override
    public List<CourseDTO> map(List<Course> courses) {
        if ( courses == null ) {
            return null;
        }

        List<CourseDTO> list = new ArrayList<CourseDTO>( courses.size() );
        for ( Course course : courses ) {
            list.add( map( course ) );
        }

        return list;
    }

    @Override
    public Course map(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setPrice( courseDTO.getPriceValue() );
        course.setRating( courseDTO.getRatingValue() );
        course.setId( courseDTO.getId() );
        course.setName( courseDTO.getName() );
        course.setDescription( courseDTO.getDescription() );
        course.setCategory( map( courseDTO.getCategory() ) );

        return course;
    }
}
