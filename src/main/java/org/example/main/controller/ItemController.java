package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.InventoryDto;
import org.example.main.dto.ItemDto;
import org.example.main.entity.Inventory;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.entity.Item;
import org.example.main.mapper.JsonMapper;
import org.example.main.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        ItemDto itemDto = jsonMapper.convertFromJsonString(jsonString, ItemDto.class);
        itemService.addItem(itemDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        itemService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") Long id, String jsonString) {
        ItemDto itemDto = jsonMapper.convertFromJsonString(jsonString, ItemDto.class);
        itemService.update(id, itemDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(itemService.findAll().stream().map(ItemDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(itemService.findAll().stream().map(ItemDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Item> items){
        return jsonMapper.convertToJsonString(items);
    }
}
