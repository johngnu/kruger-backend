package com.service.core.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private Boolean enabled;

}
