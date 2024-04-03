package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.HeroDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.example.main.service.GameModeService;
import org.example.main.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {
    private final HeroService heroService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody HeroDto heroDto) {
        heroService.addHero(heroDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        heroService.deleteHero(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody HeroDto heroDto) {
        heroService.heroEditUpdate(id, heroDto);
    }

    @GetMapping("/all")
    public List<HeroDto> findAll() {
        return heroService.FindAllHeroes();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(heroService.FindAllHeroes().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Hero> heroes) throws JsonProcessingException {
        return objectMapper.writeValueAsString(heroes);
    }
}
