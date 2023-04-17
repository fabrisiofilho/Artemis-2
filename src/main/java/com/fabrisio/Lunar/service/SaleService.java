package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.SaleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface SaleService { 
	
    SaleDTO create(SaleDTO dto);
    SaleDTO read(UUID id);
    SaleDTO update(SaleDTO dto);
    SaleDTO delete(UUID id);
    Page<SaleDTO> findAllPageable(Pageable pageable);
    
}
