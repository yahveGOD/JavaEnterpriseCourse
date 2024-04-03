package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.HeroDto;
import org.example.main.dto.InventoryDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.InventoryDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Inventory;
import org.example.main.service.HeroService;
import org.example.main.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody InventoryDto inventoryDto) {
        inventoryService.addInventory(inventoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody InventoryDto inventoryDto) {
        inventoryService.inventoryEditUpdate(id, inventoryDto);
    }

    @GetMapping("/all")
    public List<InventoryDto> findAll() {
        return inventoryService.FindAllInventories();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(inventoryService.FindAllInventories().stream().map(InventoryDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Inventory> inventories) throws JsonProcessingException {
        return objectMapper.writeValueAsString(inventories);
    }
}
