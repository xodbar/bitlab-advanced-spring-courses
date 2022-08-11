package kz.xodbar.bitlabadvancedspringcoursesproject.service;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;

public interface CourseCategoryService {

    CourseCategory addNewCategory(String categoryName);
    CourseCategory getCategoryByName(String categoryName);
    CourseCategory getCategoryById(Long id);
    List<CourseCategory> getAllCategories();
    CourseCategory editCategory(Long id, String newCategoryName);
    void deleteCategory(Long id);

}
