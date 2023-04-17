package com.fabrisio.Lunar.service;

import com.fabrisio.Lunar.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface ProductService { 
	
    ProductDTO create(ProductDTO dto);
    ProductDTO read(UUID id);
    ProductDTO update(ProductDTO dto);
    ProductDTO delete(UUID id);
    Page<ProductDTO> findAllPageable(Pageable pageable);
    
}
