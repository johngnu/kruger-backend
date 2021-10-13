package com.service.core.controller.v1;

import com.service.core.service.app.VaccineService;
import com.service.core.util.RestConstant;
import com.service.core.util.ResultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/vaccines")
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<?> vaccineList() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(vaccineService.findAll()).build(),
                HttpStatus.OK);
    }
}
