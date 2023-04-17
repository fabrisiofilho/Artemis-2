package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.StockDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface StockService { 
	
    StockDTO create(StockDTO dto);
    StockDTO read(UUID id);
    StockDTO update(StockDTO dto);
    StockDTO delete(UUID id);
    Page<StockDTO> findAllPageable(Pageable pageable);
    
}
