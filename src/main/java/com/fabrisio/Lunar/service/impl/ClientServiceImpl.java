package com.fabrisio.Lunar.service.impl;

import com.fabrisio.Lunar.dto.ClientDTO;
import com.fabrisio.Lunar.entity.ClientEntity;
import com.fabrisio.Lunar.repository.ClientRepository;
import com.fabrisio.Lunar.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
	
    @Autowired
    private ClientRepository repository;
    
	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional
    public ClientDTO create(ClientDTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, ClientEntity.class)), ClientDTO.class);
    }

    @Override
    public ClientDTO read(UUID id) {
        return modelMapper.map(repository.findById(id).orElse(null), ClientDTO.class);
    }

    @Override
    public ClientDTO update(ClientDTO dto) {
        return  modelMapper.map(repository.save(modelMapper.map(dto, ClientEntity.class)), ClientDTO.class);
    }

    @Override
    public ClientDTO delete(UUID id) {
        ClientDTO dto = read(id);
        repository.deleteById(id);
        return dto;
    }
    
	@Override
	public Page<ClientDTO> findAllPageable(Pageable pageable) {
		return repository.findAll(pageable).map(clientEntity -> modelMapper.map(clientEntity, ClientDTO.class));
	}
}
