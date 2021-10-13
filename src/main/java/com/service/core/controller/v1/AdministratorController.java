package com.service.core.controller.v1;

import com.service.core.controller.dto.EmployeeDto;
import com.service.core.model.entity.app.Employee;
import com.service.core.service.app.EmployeeService;
import com.service.core.util.RestConstant;
import com.service.core.util.ResultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/administrator")
public class AdministratorController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<?> employeesList(
            @RequestParam(required = false) Boolean vaccinated,
            @RequestParam(required = false) Integer vaccine,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateTo) {
        if (vaccinated != null) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employeeService.vaccinated(vaccinated)).build(),
                    HttpStatus.OK);
        } else if (vaccine != null) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employeeService.findByVaccine(vaccine)).build(),
                    HttpStatus.OK);
        } else if (dateFrom != null && dateTo != null) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employeeService.findByVaccineDate(dateFrom, dateTo)).build(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employeeService.findAll()).build(),
                    HttpStatus.OK);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<?> registerEmployee(@RequestBody EmployeeDto employeeDto) {
        if (!employeeService.findByCedula(employeeDto.getCedula()).isPresent()) {
            Employee employee = employeeService.persist(employeeDto);
            log.info(RestConstant.LOG_PERSIST, employee.getId());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_PERSIST_SUCCESSFULY).data(employee.getId()).build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message("Employee'cedula already exists ").data(null).build(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.get(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(employee.get()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.get(id);
        if (employee.isPresent()) {
            employeeService.delete(employee.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(null).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.NOT_FOUND);
    }
}
