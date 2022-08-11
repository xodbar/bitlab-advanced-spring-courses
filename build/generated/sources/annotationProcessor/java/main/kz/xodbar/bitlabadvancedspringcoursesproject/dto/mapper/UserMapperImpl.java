package kz.xodbar.bitlabadvancedspringcoursesproject.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.xodbar.bitlabadvancedspringcoursesproject.dto.pojo.user.UserDTO;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-11T17:49:49+0600",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 18.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO map(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setFullName( user.getFullName() );

        return userDTO;
    }

    @Override
    public List<UserDTO> map(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( map( user ) );
        }

        return list;
    }

    @Override
    public User map(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setEmail( userDTO.getEmail() );
        user.setFullName( userDTO.getFullName() );

        return user;
    }
}
