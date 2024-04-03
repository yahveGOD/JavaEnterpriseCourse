package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.ReplayDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Replay;
import org.example.main.service.PickedHeroService;
import org.example.main.service.ReplayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/replay")
@RequiredArgsConstructor
public class ReplayController {
    private final ReplayService replayService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody ReplayDto replayDto) {
        replayService.addReplay(replayDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        replayService.deleteReplay(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody ReplayDto replayDto) {
        replayService.replayEditUpdate(id, replayDto);
    }

    @GetMapping("/all")
    public List<ReplayDto> findAll() {
        return replayService.FindAllReplays();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(replayService.FindAllReplays().stream().map(ReplayDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Replay> replays) throws JsonProcessingException {
        return objectMapper.writeValueAsString(replays);
    }
}
