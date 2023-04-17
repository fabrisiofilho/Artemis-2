package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.EmployeeDTO;
import com.fabrisio.Lunar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("employee")
public class EmployeeController { 
	
    @Autowired
    private EmployeeService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<EmployeeDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
