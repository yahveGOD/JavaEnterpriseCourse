package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ability.AbilityDto;
import org.example.main.dto.ability.AbilityDtoMapper;
import org.example.main.entity.Ability;
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
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody AbilityDto abilityDto) {
        abilityService.addAbility(abilityDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        abilityService.deleteAbility(id);

    }

    @PostMapping("/{id}/edit")
    public void EditUpdate(@PathVariable(value = "id") int id, @RequestBody AbilityDto abilityDto) {
        abilityService.abilityEditUpdate(id, abilityDto);
    }

    @GetMapping("/all")
    public List<AbilityDto> findAll() {
        return abilityService.FindAllAbilities();
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(abilityService.FindAllAbilities().stream().map(AbilityDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Ability> abilities) throws JsonProcessingException {
        return objectMapper.writeValueAsString(abilities);
    }
}
