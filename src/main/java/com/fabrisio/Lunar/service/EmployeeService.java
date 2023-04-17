package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface EmployeeService { 
	
    EmployeeDTO create(EmployeeDTO dto);
    EmployeeDTO read(UUID id);
    EmployeeDTO update(EmployeeDTO dto);
    EmployeeDTO delete(UUID id);
    Page<EmployeeDTO> findAllPageable(Pageable pageable);
    
}
