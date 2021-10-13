package com.service.core.service.app;

import com.service.core.model.entity.app.Employee;
import com.service.core.model.entity.app.Vaccine;
import com.service.core.model.repository.app.EmployeeRepository;
import com.service.core.model.repository.app.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }
}
