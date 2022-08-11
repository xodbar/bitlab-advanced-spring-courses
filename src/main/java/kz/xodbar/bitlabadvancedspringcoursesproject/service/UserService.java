package kz.xodbar.bitlabadvancedspringcoursesproject.service;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.user.UserDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User addNewUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);

}
