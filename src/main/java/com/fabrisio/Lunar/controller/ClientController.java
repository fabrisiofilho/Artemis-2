package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.ClientDTO;
import com.fabrisio.Lunar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController { 
	
    @Autowired
    private ClientService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<ClientDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
