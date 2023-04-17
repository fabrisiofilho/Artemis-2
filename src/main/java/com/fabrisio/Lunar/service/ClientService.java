package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface ClientService { 
	
    ClientDTO create(ClientDTO dto);
    ClientDTO read(UUID id);
    ClientDTO update(ClientDTO dto);
    ClientDTO delete(UUID id);
    Page<ClientDTO> findAllPageable(Pageable pageable);
    
}
