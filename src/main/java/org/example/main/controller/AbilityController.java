package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.AbilityDto;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.mapper.JsonMapper;
import org.example.main.service.AbilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ability")
@RequiredArgsConstructor
public class AbilityController {
    private final AbilityService abilityService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
            AbilityDto abilityDto = jsonMapper.convertFromJsonString(jsonString, AbilityDto.class);
            abilityService.addAbility(abilityDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        abilityService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") Long id, String jsonString) {
            AbilityDto abilityDto = jsonMapper.convertFromJsonString(jsonString, AbilityDto.class);
            abilityService.update(id, abilityDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(abilityService.findAll().stream().map(AbilityDtoMapper::convertDtoToEntity).toList());
        return json;
    }
    @GetMapping("/id")
    public String findById(@PathVariable Long id)
    {
        String json = jsonMapper.convertToJsonString(abilityService.findById(id));
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(abilityService.findAll().stream().map(AbilityDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Ability> abilities){
        return jsonMapper.convertToJsonString(abilities);
    }
}
