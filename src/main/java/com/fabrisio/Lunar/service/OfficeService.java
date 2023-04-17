package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.OfficeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface OfficeService { 
	
    OfficeDTO create(OfficeDTO dto);
    OfficeDTO read(UUID id);
    OfficeDTO update(OfficeDTO dto);
    OfficeDTO delete(UUID id);
    Page<OfficeDTO> findAllPageable(Pageable pageable);
    
}
