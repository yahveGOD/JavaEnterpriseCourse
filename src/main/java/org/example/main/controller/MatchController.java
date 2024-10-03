package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.MatchDto;
import org.example.main.entity.Item;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.entity.Match;
import org.example.main.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(@RequestBody MatchDto matchDto) {
        matchService.addMatch(matchDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        matchService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public void editUpdate(@PathVariable("id") Long id, MatchDto matchDto) {
        matchService.update(id, matchDto);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id)
    {
        String json = jsonMapper.convertToJsonString(matchService.findById(id));
        return json;
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(matchService.findAll().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(matchService.findAll().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Match> matches){
        return jsonMapper.convertToJsonString(matches);
    }
}
