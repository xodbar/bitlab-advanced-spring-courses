package kz.xodbar.bitlabadvancedspringcoursesproject.repository;

import javax.transaction.Transactional;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CourseRepos extends JpaRepository<Course, Long> {
}
