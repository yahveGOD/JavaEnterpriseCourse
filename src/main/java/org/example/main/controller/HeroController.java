package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.hero.HeroDto;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.entity.Hero;
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
