package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.ManufacturerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface ManufacturerService { 
	
    ManufacturerDTO create(ManufacturerDTO dto);
    ManufacturerDTO read(UUID id);
    ManufacturerDTO update(ManufacturerDTO dto);
    ManufacturerDTO delete(UUID id);
    Page<ManufacturerDTO> findAllPageable(Pageable pageable);
    
}
