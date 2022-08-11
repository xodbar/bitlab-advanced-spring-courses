package kz.xodbar.bitlabadvancedspringcoursesproject.service.impl;

import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.Role;
import kz.xodbar.bitlabadvancedspringcoursesproject.repository.RoleRepos;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepos roleRepository;

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }
}
