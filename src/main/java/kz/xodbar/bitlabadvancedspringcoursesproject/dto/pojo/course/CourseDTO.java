package kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private int priceValue;
    private double ratingValue;
    private CourseCategoryDTO category;

}
