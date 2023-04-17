package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.SaleItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface SaleItemService { 
	
    SaleItemDTO create(SaleItemDTO dto);
    SaleItemDTO read(UUID id);
    SaleItemDTO update(SaleItemDTO dto);
    SaleItemDTO delete(UUID id);
    Page<SaleItemDTO> findAllPageable(Pageable pageable);
    
}
