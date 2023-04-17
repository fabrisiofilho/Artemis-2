package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.ManufacturerDTO;
import com.fabrisio.Lunar.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("manufacturer")
public class ManufacturerController { 
	
    @Autowired
    private ManufacturerService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<ManufacturerDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<ManufacturerDTO> update(@RequestBody ManufacturerDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<ManufacturerDTO> create(@RequestBody ManufacturerDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
