package kz.xodbar.bitlabadvancedspringcoursesproject.service.impl;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;
import kz.xodbar.bitlabadvancedspringcoursesproject.repository.CourseCategoryRepos;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepos courseCategoryRepository;

    @Override
    public CourseCategory addNewCategory(String categoryName) {
        return courseCategoryRepository.save(new CourseCategory(null, categoryName));
    }

    @Override
    public CourseCategory getCategoryByName(String categoryName) {
        return courseCategoryRepository.findByName(categoryName);
    }

    @Override
    public CourseCategory getCategoryById(Long id) {
        return courseCategoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CourseCategory> getAllCategories() {
        return courseCategoryRepository.findAll();
    }

    @Override
    public CourseCategory editCategory(Long id, String newCategoryName) {
        return courseCategoryRepository.save(new CourseCategory(id, newCategoryName));
    }

    @Override
    public void deleteCategory(Long id) {
        courseCategoryRepository.deleteById(id);
    }
}
