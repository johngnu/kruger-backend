package com.service.core.service.security;

import com.service.core.controller.dto.UserDto;
import com.service.core.model.entity.security.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {
    @Transactional(readOnly = true)
    Optional<User> findByUsername(String username);

    //@Transactional(readOnly = true)
    //Optional<User> findByEmail(String email);

    @Transactional(readOnly = true)
    Optional<User> get(long id);

    @Transactional(readOnly = true)
    List<User> findAll();

    @Transactional
    User persist(UserDto userDto);

    @Transactional
    void update(User user);
}
