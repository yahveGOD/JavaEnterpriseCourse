package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.gamemode.GameModeDto;
import org.example.main.dto.gamemode.GameModeDtoMapper;
import org.example.main.entity.GameMode;
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
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody GameModeDto gameModeDto) {
        gameModeService.addGameMode(gameModeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        gameModeService.deleteGameMode(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody GameModeDto gameModeDto) {
        gameModeService.gameModeEditUpdate(id, gameModeDto);
    }

    @GetMapping("/all")
    public List<GameModeDto> findAll() {
        return gameModeService.FindAllGameModes();
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(gameModeService.FindAllGameModes().stream().map(GameModeDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<GameMode> gameModes) throws JsonProcessingException {
        return objectMapper.writeValueAsString(gameModes);
    }
}
