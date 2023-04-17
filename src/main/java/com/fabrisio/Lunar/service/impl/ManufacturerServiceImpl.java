package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.ManufacturerDTO;
import com.fabrisio.Lunar.entity.ManufacturerEntity;
import com.fabrisio.Lunar.repository.ManufacturerRepository;
import com.fabrisio.Lunar.service.ManufacturerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
	
    @Autowired
    private ManufacturerRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public ManufacturerDTO create(ManufacturerDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, ManufacturerEntity.class)), ManufacturerDTO.class);
    }

    @Override
    public ManufacturerDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), ManufacturerDTO.class);
    }

    @Override
    public ManufacturerDTO update(ManufacturerDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, ManufacturerEntity.class)), ManufacturerDTO.class);
    }

    @Override
    public ManufacturerDTO delete(UUID id) {
        ManufacturerDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<ManufacturerDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(manufacturerEntity -> modelMapper.map(manufacturerEntity, ManufacturerDTO.class));
	}
}
