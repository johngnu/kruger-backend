package com.service.core.controller.v1;

import com.service.core.controller.dto.UserDto;
import com.service.core.model.entity.security.User;
import com.service.core.util.RestConstant;
import com.service.core.util.ResultResponse;
import com.service.core.service.security.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public ResponseEntity<?> findAll(String username) {
        if (username != null) {
            Optional<User> user = userService.findByUsername(username);
            if (user.isPresent())
                return new ResponseEntity<>(ResultResponse.builder().status(false).message("username ya en uso").build(), HttpStatus.OK);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message("username disponible").build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(userService.findAll()).build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> persist(@RequestBody UserDto userDto) {
        if (!userService.findByUsername(userDto.getUsername()).isPresent()) {
            User persist = userService.persist(userDto);
            log.info(RestConstant.LOG_PERSIST, persist.getId());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_PERSIST_SUCCESSFULY).data(persist.getId()).build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message("Username ya registrado, eliga otro.").data(null).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        Optional<User> user = userService.get(id);
        if (user.isPresent()) {
            user.get().setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            userService.update(user.get());
            log.info(RestConstant.LOG_UPDATE, user.get().getId());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(user.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }
}
