package kz.xodbar.bitlabadvancedspringcoursesproject.repository;

import javax.transaction.Transactional;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepos extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
