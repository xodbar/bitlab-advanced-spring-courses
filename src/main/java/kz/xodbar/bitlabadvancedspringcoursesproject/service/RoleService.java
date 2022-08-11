package kz.xodbar.bitlabadvancedspringcoursesproject.service;

import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.Role;

public interface RoleService {

    Role addNewRole(Role role);
    Role getRoleById(Long id);

}
