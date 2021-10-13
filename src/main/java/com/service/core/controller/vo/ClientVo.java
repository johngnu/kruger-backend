package com.service.core.controller.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientVo {
    private Long id;
    private String completeName;
    private String birthday;
    private String gender;
    private String email;
    private String mobileNumber;
    private String nit;
    private String businessName;
    private Boolean enabled;
}