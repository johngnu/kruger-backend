package com.service.core.model.repository.security;

import com.service.core.model.entity.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findAllByUserId(Long userId);

    List<UserRole> findAllByRoleId(Long roleId);
}
