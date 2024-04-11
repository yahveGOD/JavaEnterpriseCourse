package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.GameModeDto;
import org.example.main.entity.Ability;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.entity.GameMode;
import org.example.main.mapper.JsonMapper;
import org.example.main.service.GameModeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game_mode")
@RequiredArgsConstructor
public class GameModeController {
    private final GameModeService gameModeService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        GameModeDto gameModeDto = jsonMapper.convertFromJsonString(jsonString, GameModeDto.class);
        gameModeService.addGameMode(gameModeDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        gameModeService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        GameModeDto gameModeDto = jsonMapper.convertFromJsonString(jsonString, GameModeDto.class);
        gameModeService.update(id, gameModeDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(gameModeService.findAll().stream().map(GameModeDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(gameModeService.findAll().stream().map(GameModeDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<GameMode> gameModes){
        return jsonMapper.convertToJsonString(gameModes);
    }
}
