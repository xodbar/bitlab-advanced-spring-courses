package kz.xodbar.bitlabadvancedspringcoursesproject.repository;

import javax.transaction.Transactional;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepos extends JpaRepository<Role, Long> {
}
