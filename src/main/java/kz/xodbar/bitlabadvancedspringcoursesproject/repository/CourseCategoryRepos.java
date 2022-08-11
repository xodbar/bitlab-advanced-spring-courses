package kz.xodbar.bitlabadvancedspringcoursesproject.repository;

import javax.transaction.Transactional;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseCategoryRepos extends JpaRepository<CourseCategory, Long> {

    CourseCategory findByName(String categoryName);

}
