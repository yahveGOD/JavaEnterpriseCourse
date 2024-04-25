package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.ReplayDto;
import org.example.main.entity.Item;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.entity.Replay;
import org.example.main.service.ReplayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replay")
@RequiredArgsConstructor
public class ReplayController {
    private final ReplayService replayService;
    private final JsonMapper jsonMapper;
    @PostMapping("/create")
    public void create(String jsonString) {
        ReplayDto replayDto = jsonMapper.convertFromJsonString(jsonString, ReplayDto.class);
        replayService.addReplay(replayDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        replayService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") Long id, String jsonString) {
        ReplayDto replayDto = jsonMapper.convertFromJsonString(jsonString, ReplayDto.class);
        replayService.update(id, replayDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(replayService.findAll().stream().map(ReplayDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(replayService.findAll().stream().map(ReplayDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Replay> replays){
        return jsonMapper.convertToJsonString(replays);
    }
}
