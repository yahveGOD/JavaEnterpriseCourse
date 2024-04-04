package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.item.ItemDto;
import org.example.main.dto.item.ItemDtoMapper;
import org.example.main.entity.Item;
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
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody ItemDto itemDto) {
        itemService.addItem(itemDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        itemService.deleteItem(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody ItemDto itemDto) {
        itemService.itemEditUpdate(id, itemDto);
    }

    @GetMapping("/all")
    public List<ItemDto> findAll() {
        return itemService.FindAllItems();
    }


    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(itemService.FindAllItems().stream().map(ItemDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Item> items) throws JsonProcessingException {
        return objectMapper.writeValueAsString(items);
    }
}
