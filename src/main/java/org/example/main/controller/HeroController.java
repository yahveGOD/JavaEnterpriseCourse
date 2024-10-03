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
@RequestMapping("api/v1/hero")
@RequiredArgsConstructor
public class HeroController {
    private final HeroService heroService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(@RequestBody HeroDto heroDto) {
        heroService.addHero(heroDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        heroService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public void editUpdate(@PathVariable("id") Long id,HeroDto heroDto) {
        heroService.update(id, heroDto);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id)
    {
        String json = jsonMapper.convertToJsonString(heroService.findById(id));
        return json;
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(heroService.findAll().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(heroService.findAll().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Hero> heroes){
        return jsonMapper.convertToJsonString(heroes);
    }
}
