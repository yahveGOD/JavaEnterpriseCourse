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
@RequestMapping("api/v1/replay")
@RequiredArgsConstructor
public class ReplayController {
    private final ReplayService replayService;
    private final JsonMapper jsonMapper;
    @PostMapping("/create")
    public void create(@RequestBody ReplayDto replayDto) {
        replayService.addReplay(replayDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        replayService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public void editUpdate(@PathVariable("id") Long id, ReplayDto replayDto) {
        replayService.update(id, replayDto);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id)
    {
        String json = jsonMapper.convertToJsonString(replayService.findById(id));
        return json;
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
