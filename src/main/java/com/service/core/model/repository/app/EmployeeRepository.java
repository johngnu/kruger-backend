package com.service.core.model.repository.app;

import com.service.core.model.entity.app.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByCedula(String cedula);

    List<Employee> findByVacunadoIs(Boolean estado);

    List<Employee> findByVaccineId(Integer vaccineId);

    List<Employee> findByVaccineDateBetween(Date dateFrom, Date dateTo);
}
