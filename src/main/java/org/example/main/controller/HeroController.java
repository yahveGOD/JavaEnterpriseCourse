package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.HeroDto;
import org.example.main.entity.GameMode;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.mapper.JsonMapper;
import org.example.main.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {
    private final HeroService heroService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        HeroDto heroDto = jsonMapper.convertFromJsonString(jsonString, HeroDto.class);
        heroService.addHero(heroDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        heroService.deleteHero(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        HeroDto heroDto = jsonMapper.convertFromJsonString(jsonString, HeroDto.class);
        heroService.heroEditUpdate(id, heroDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(heroService.findAllHeroes().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(heroService.findAllHeroes().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Hero> heroes){
        return jsonMapper.convertToJsonString(heroes);
    }
}
