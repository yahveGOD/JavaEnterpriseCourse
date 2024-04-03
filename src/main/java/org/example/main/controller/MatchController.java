package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.MatchDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.MatchDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Match;
import org.example.main.service.ItemService;
import org.example.main.service.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController {
    private final MatchService matchService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody MatchDto matchDto) {
        matchService.addMatch(matchDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        matchService.deleteMatch(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody MatchDto matchDto) {
        matchService.matchEditUpdate(id, matchDto);
    }

    @GetMapping("/all")
    public List<MatchDto> findAll() {
        return matchService.FindAllMatches();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(matchService.FindAllMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Match> matches) throws JsonProcessingException {
        return objectMapper.writeValueAsString(matches);
    }
}
