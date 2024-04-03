package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.MatchDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.PickedHeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.PickedHero;
import org.example.main.service.PickedHeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/picked_hero")
@RequiredArgsConstructor
public class PickedHeroController {
    private final PickedHeroService pickedHeroService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody PickedHeroDto pickedHeroDto) {
        pickedHeroService.addPickedHero(pickedHeroDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        pickedHeroService.deletePickedHero(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody PickedHeroDto pickedHeroDto) {
        pickedHeroService.pickedHeroEditUpdate(id, pickedHeroDto);
    }

    @GetMapping("/all")
    public List<PickedHeroDto> findAll() {
        return pickedHeroService.FindAllPickedHeroes();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(pickedHeroService.FindAllPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<PickedHero> pickedHeroes) throws JsonProcessingException {
        return objectMapper.writeValueAsString(pickedHeroes);
    }
}
