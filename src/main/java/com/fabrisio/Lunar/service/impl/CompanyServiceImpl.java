package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.CompanyDTO;
import com.fabrisio.Lunar.entity.CompanyEntity;
import com.fabrisio.Lunar.repository.CompanyRepository;
import com.fabrisio.Lunar.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {
	
    @Autowired
    private CompanyRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public CompanyDTO create(CompanyDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, CompanyEntity.class)), CompanyDTO.class);
    }

    @Override
    public CompanyDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), CompanyDTO.class);
    }

    @Override
    public CompanyDTO update(CompanyDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, CompanyEntity.class)), CompanyDTO.class);
    }

    @Override
    public CompanyDTO delete(UUID id) {
        CompanyDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<CompanyDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(companyEntity -> modelMapper.map(companyEntity, CompanyDTO.class));
	}
}
