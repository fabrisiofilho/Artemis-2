package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.CashierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CashierService { 
	
    CashierDTO create(CashierDTO dto);
    CashierDTO read(UUID id);
    CashierDTO update(CashierDTO dto);
    CashierDTO delete(UUID id);
    Page<CashierDTO> findAllPageable(Pageable pageable);
    
}
