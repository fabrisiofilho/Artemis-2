package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.ProductDTO;
import com.fabrisio.Lunar.entity.ProductEntity;
import com.fabrisio.Lunar.repository.ProductRepository;
import com.fabrisio.Lunar.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
	
    @Autowired
    private ProductRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public ProductDTO create(ProductDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, ProductEntity.class)), ProductDTO.class);
    }

    @Override
    public ProductDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, ProductEntity.class)), ProductDTO.class);
    }

    @Override
    public ProductDTO delete(UUID id) {
        ProductDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<ProductDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(productEntity -> modelMapper.map(productEntity, ProductDTO.class));
	}
}
