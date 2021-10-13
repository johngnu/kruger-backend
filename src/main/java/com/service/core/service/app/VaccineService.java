package com.service.core.service.app;

import com.service.core.model.entity.app.Employee;
import com.service.core.model.entity.app.Vaccine;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VaccineService {
    @Transactional(readOnly = true)
    List<Vaccine> findAll();
}
