package com.service.core.service.security;

import com.service.core.model.entity.security.Role;
import com.service.core.model.entity.security.UserRole;
import com.service.core.model.repository.security.RoleRepository;
import com.service.core.model.repository.security.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<Role> findAllByUserId(Long userId) {
        List<UserRole> list = userRoleRepository.findAllByUserId(userId);
        List<Role> result = new ArrayList<>();
        list.forEach(userRole -> result.add(roleRepository.findById(userRole.getRoleId()).get()));
        return result;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
