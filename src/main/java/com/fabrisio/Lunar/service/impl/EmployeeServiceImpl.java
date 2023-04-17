package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.EmployeeDTO;
import com.fabrisio.Lunar.entity.EmployeeEntity;
import com.fabrisio.Lunar.repository.EmployeeRepository;
import com.fabrisio.Lunar.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
    private EmployeeRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public EmployeeDTO create(EmployeeDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, EmployeeEntity.class)), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, EmployeeEntity.class)), EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO delete(UUID id) {
        EmployeeDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<EmployeeDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
	}
}
