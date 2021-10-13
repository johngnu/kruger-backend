package com.service.core.service.app;

import com.service.core.controller.dto.EmployeeDto;
import com.service.core.controller.dto.EmployeeUpdateDto;
import com.service.core.model.entity.app.Employee;
import com.service.core.model.entity.config.Parameter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    @Transactional(readOnly = true)
    List<Employee> findAll();

    @Transactional(readOnly = true)
    List<Employee> vaccinated(Boolean status);

    @Transactional(readOnly = true)
    List<Employee> findByVaccine(Integer vaccine);

    @Transactional(readOnly = true)
    List<Employee> findByVaccineDate(Date dateFrom, Date dateTo);

    @Transactional(readOnly = true)
    Optional<Employee> findByCedula(String cedula);

    @Transactional
    Employee persist(EmployeeDto employeeDto);

    @Transactional(readOnly = true)
    Optional<Employee> get(long id);

    @Transactional
    void update(Employee employee, EmployeeUpdateDto employeeDto);

    @Transactional
    void delete(Parameter parameter);
}
