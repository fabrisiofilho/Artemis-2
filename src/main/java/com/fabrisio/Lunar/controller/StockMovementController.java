package com.fabrisio.Lunar.controller;

import com.fabrisio.Lunar.dto.StockMovementDTO;
import com.fabrisio.Lunar.service.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("stock_movement")
public class StockMovementController { 
	
    @Autowired
    private StockMovementService service;

    @GetMapping("/page/{page}")
    public ResponseEntity<Page<StockMovementDTO>> findAllPageable(@PathVariable String page){
        return ResponseEntity.ok(service.findAllPageable(PageRequest.of(Integer.parseInt(page), 8)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovementDTO> read(@PathVariable UUID id){
        return ResponseEntity.ok(service.read(id));
    }

    @PutMapping
    public ResponseEntity<StockMovementDTO> update(@RequestBody StockMovementDTO updated){
        return ResponseEntity.ok(service.update(updated));
    }

    @PostMapping
    public ResponseEntity<StockMovementDTO> create(@RequestBody StockMovementDTO created){
        return ResponseEntity.ok(service.create(created));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StockMovementDTO> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
}
