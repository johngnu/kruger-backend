package com.service.core.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class EmployeeUpdateDto {
    @ApiModelProperty(example = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    private String address;
    @ApiModelProperty(example = "77723873")
    private Integer movil;
    private Boolean vacunado;
    private Integer vaccineId;
    private Integer nroDosis;
    @ApiModelProperty(example = "dd/MM/yyyy")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date vaccineDate;
}
