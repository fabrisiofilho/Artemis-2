package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.SaleItemDTO;
import com.fabrisio.Lunar.entity.SaleItemEntity;
import com.fabrisio.Lunar.repository.SaleItemRepository;
import com.fabrisio.Lunar.service.SaleItemService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SaleItemServiceImpl implements SaleItemService {
	
    @Autowired
    private SaleItemRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public SaleItemDTO create(SaleItemDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, SaleItemEntity.class)), SaleItemDTO.class);
    }

    @Override
    public SaleItemDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), SaleItemDTO.class);
    }

    @Override
    public SaleItemDTO update(SaleItemDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, SaleItemEntity.class)), SaleItemDTO.class);
    }

    @Override
    public SaleItemDTO delete(UUID id) {
        SaleItemDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<SaleItemDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(saleItemEntity -> modelMapper.map(saleItemEntity, SaleItemDTO.class));
	}
}
