package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.OfficeDTO;
import com.fabrisio.Lunar.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("office")
public class OfficeController { 
	
    @Autowired
    private OfficeService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<OfficeDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfficeDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<OfficeDTO> update(@RequestBody OfficeDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<OfficeDTO> create(@RequestBody OfficeDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OfficeDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
