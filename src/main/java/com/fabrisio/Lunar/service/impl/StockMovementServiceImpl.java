package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.StockMovementDTO;
import com.fabrisio.Lunar.entity.StockMovementEntity;
import com.fabrisio.Lunar.repository.StockMovementRepository;
import com.fabrisio.Lunar.service.StockMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StockMovementServiceImpl implements StockMovementService {
	
    @Autowired
    private StockMovementRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public StockMovementDTO create(StockMovementDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, StockMovementEntity.class)), StockMovementDTO.class);
    }

    @Override
    public StockMovementDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), StockMovementDTO.class);
    }

    @Override
    public StockMovementDTO update(StockMovementDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, StockMovementEntity.class)), StockMovementDTO.class);
    }

    @Override
    public StockMovementDTO delete(UUID id) {
        StockMovementDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<StockMovementDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(stockMovementEntity -> modelMapper.map(stockMovementEntity, StockMovementDTO.class));
	}
}
