package com.service.core.service.security;

import com.service.core.model.entity.security.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface RoleService {
    @Transactional(readOnly = true)
    List<Role> findAllByUserId(Long userId);

    @Transactional(readOnly = true)
    Optional<Role> findByName(String name);
}
