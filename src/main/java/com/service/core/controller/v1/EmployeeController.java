package com.service.core.controller.v1;

import com.service.core.controller.dto.EmployeeUpdateDto;
import com.service.core.model.entity.app.Employee;
import com.service.core.service.app.EmployeeService;
import com.service.core.util.RestConstant;
import com.service.core.util.ResultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> employeesList() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employeeService.findAll()).build(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.get(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employee.get()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeUpdateDto employeeDto) {
        Optional<Employee> employee = employeeService.get(id);
        if (employee.isPresent()) {
            employeeService.update(employee.get(), employeeDto);
            log.info(RestConstant.LOG_UPDATE, id);
            //employeeDto.getBirthday().get
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(employee.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.NOT_FOUND);
    }

}
