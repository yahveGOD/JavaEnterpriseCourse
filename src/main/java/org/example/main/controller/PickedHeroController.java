package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.MatchDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.entity.Match;
import org.example.main.entity.PickedHero;
import org.example.main.service.PickedHeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/picked_hero")
@RequiredArgsConstructor
public class PickedHeroController {
    private final PickedHeroService pickedHeroService;
    private final JsonMapper jsonMapper;
    @PostMapping("/create")
    public void create(String jsonString) {
        PickedHeroDto pickedHeroDto = jsonMapper.convertFromJsonString(jsonString, PickedHeroDto.class);
        pickedHeroService.addPickedHero(pickedHeroDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        pickedHeroService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "match")Match match,@PathVariable(value = "hero") Hero hero, String jsonString) {

        PickedHeroDto pickedHeroDto = jsonMapper.convertFromJsonString(jsonString, PickedHeroDto.class);

        pickedHeroService.update(hero,match, pickedHeroDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(pickedHeroService.findAll().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(pickedHeroService.findAll().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<PickedHero> pickedHeroes){
        return jsonMapper.convertToJsonString(pickedHeroes);
    }
}
