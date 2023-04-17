package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.OfficeDTO;
import com.fabrisio.Lunar.entity.OfficeEntity;
import com.fabrisio.Lunar.repository.OfficeRepository;
import com.fabrisio.Lunar.service.OfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OfficeServiceImpl implements OfficeService {
	
    @Autowired
    private OfficeRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public OfficeDTO create(OfficeDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, OfficeEntity.class)), OfficeDTO.class);
    }

    @Override
    public OfficeDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), OfficeDTO.class);
    }

    @Override
    public OfficeDTO update(OfficeDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, OfficeEntity.class)), OfficeDTO.class);
    }

    @Override
    public OfficeDTO delete(UUID id) {
        OfficeDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<OfficeDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(officeEntity -> modelMapper.map(officeEntity, OfficeDTO.class));
	}
}
