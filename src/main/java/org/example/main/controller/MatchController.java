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
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        MatchDto matchDto = jsonMapper.convertFromJsonString(jsonString, MatchDto.class);
        matchService.addMatch(matchDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        matchService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") Long id, String jsonString) {
        MatchDto matchDto = jsonMapper.convertFromJsonString(jsonString, MatchDto.class);
        matchService.update(id, matchDto);
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
