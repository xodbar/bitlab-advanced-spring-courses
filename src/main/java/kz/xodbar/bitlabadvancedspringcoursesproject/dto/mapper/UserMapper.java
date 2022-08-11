package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.user.UserDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    UserDTO map(User user);
    List<UserDTO> map(List<User> users);
    User map(UserDTO userDTO);

}
