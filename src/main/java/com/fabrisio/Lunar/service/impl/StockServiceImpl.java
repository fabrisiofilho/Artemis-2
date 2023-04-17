package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.StockDTO;
import com.fabrisio.Lunar.entity.StockEntity;
import com.fabrisio.Lunar.repository.StockRepository;
import com.fabrisio.Lunar.service.StockService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {
	
    @Autowired
    private StockRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public StockDTO create(StockDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, StockEntity.class)), StockDTO.class);
    }

    @Override
    public StockDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), StockDTO.class);
    }

    @Override
    public StockDTO update(StockDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, StockEntity.class)), StockDTO.class);
    }

    @Override
    public StockDTO delete(UUID id) {
        StockDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<StockDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(stockEntity -> modelMapper.map(stockEntity, StockDTO.class));
	}
}
