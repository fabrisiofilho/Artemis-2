package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface CompanyService { 
	
    CompanyDTO create(CompanyDTO dto);
    CompanyDTO read(UUID id);
    CompanyDTO update(CompanyDTO dto);
    CompanyDTO delete(UUID id);
    Page<CompanyDTO> findAllPageable(Pageable pageable);
    
}
