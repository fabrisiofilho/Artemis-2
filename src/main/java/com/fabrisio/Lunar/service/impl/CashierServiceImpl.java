package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.CashierDTO;
import com.fabrisio.Lunar.entity.CashierEntity;
import com.fabrisio.Lunar.repository.CashierRepository;
import com.fabrisio.Lunar.service.CashierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CashierServiceImpl implements CashierService {
	
    @Autowired
    private CashierRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public CashierDTO create(CashierDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, CashierEntity.class)), CashierDTO.class);
    }

    @Override
    public CashierDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), CashierDTO.class);
    }

    @Override
    public CashierDTO update(CashierDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, CashierEntity.class)), CashierDTO.class);
    }

    @Override
    public CashierDTO delete(UUID id) {
        CashierDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<CashierDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(cashierEntity -> modelMapper.map(cashierEntity, CashierDTO.class));
	}
}
