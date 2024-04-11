package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.HeroDto;
import org.example.main.dto.InventoryDto;
import org.example.main.entity.Hero;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.entity.Inventory;
import org.example.main.mapper.JsonMapper;
import org.example.main.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        InventoryDto inventoryDto = jsonMapper.convertFromJsonString(jsonString, InventoryDto.class);
        inventoryService.addInventory(inventoryDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        inventoryService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        InventoryDto inventoryDto = jsonMapper.convertFromJsonString(jsonString, InventoryDto.class);
        inventoryService.update(id, inventoryDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(inventoryService.findAll().stream().map(InventoryDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(inventoryService.findAll().stream().map(InventoryDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Inventory> inventories){
        return jsonMapper.convertToJsonString(inventories);
    }
}
