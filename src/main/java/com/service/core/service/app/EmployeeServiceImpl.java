package com.service.core.service.app;

import com.service.core.controller.dto.EmployeeDto;
import com.service.core.controller.dto.EmployeeUpdateDto;
import com.service.core.model.entity.app.Employee;
import com.service.core.model.entity.config.Parameter;
import com.service.core.model.repository.app.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> vaccinated(Boolean status) {
        return employeeRepository.findByVacunadoIs(status);
    }

    @Override
    public List<Employee> findByVaccine(Integer vaccine) {
        return employeeRepository.findByVaccineId(vaccine);
    }

    @Override
    public List<Employee> findByVaccineDate(Date dateFrom, Date dateTo) {
        return employeeRepository.findByVaccineDateBetween(dateFrom, dateTo);
    }

    @Override
    public Optional<Employee> findByCedula(String cedula) {
        return employeeRepository.findByCedula(cedula);
    }

    @Override
    public Employee persist(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Optional<Employee> get(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee, EmployeeUpdateDto employeeDto) {
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
