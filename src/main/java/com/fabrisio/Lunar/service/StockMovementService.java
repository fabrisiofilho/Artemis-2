package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.StockMovementDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface StockMovementService { 
	
    StockMovementDTO create(StockMovementDTO dto);
    StockMovementDTO read(UUID id);
    StockMovementDTO update(StockMovementDTO dto);
    StockMovementDTO delete(UUID id);
    Page<StockMovementDTO> findAllPageable(Pageable pageable);
    
}
