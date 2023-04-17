package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.SaleDTO;
import com.fabrisio.Lunar.entity.SaleEntity;
import com.fabrisio.Lunar.repository.SaleRepository;
import com.fabrisio.Lunar.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SaleServiceImpl implements SaleService {
	
    @Autowired
    private SaleRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public SaleDTO create(SaleDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, SaleEntity.class)), SaleDTO.class);
    }

    @Override
    public SaleDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), SaleDTO.class);
    }

    @Override
    public SaleDTO update(SaleDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, SaleEntity.class)), SaleDTO.class);
    }

    @Override
    public SaleDTO delete(UUID id) {
        SaleDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<SaleDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(saleEntity -> modelMapper.map(saleEntity, SaleDTO.class));
	}
}
