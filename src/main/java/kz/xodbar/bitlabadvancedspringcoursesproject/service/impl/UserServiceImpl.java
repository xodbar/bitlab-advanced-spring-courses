package kz.xodbar.bitlabadvancedspringcoursesproject.service.impl;

import java.util.Collections;
import java.util.List;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.Role;
import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import kz.xodbar.bitlabadvancedspringcoursesproject.repository.UserRepos;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.RoleService;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepos userRepository;

    @Autowired
    private RoleService roleService;


    @Override
    public User addNewUser(User user) {
        if (user == null)
            return null;

        if (userRepository.findByEmail(user.getEmail()) != null)
            return null;

        if (user.getRoles() == null || user.getRoles().isEmpty())
            user.setRoles(defaultRoles());

        user.setPassword(defaultPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }


    private PasswordEncoder defaultPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private List<Role> defaultRoles() {
        return Collections.singletonList(roleService.getRoleById(3L));
    }
}
