package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.CompanyDTO;
import com.fabrisio.Lunar.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("company")
public class CompanyController { 
	
    @Autowired
    private CompanyService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<CompanyDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
