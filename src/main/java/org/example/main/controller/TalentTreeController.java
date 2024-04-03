package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.TalentTreeDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.TalentTree;
import org.example.main.service.StatisticsService;
import org.example.main.service.TalentTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/talent_tree")
@RequiredArgsConstructor
public class TalentTreeController {
    private final TalentTreeService talentTreeService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody TalentTreeDto talentTreeDto) {
        talentTreeService.addTalentTree(talentTreeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        talentTreeService.deleteTalentTree(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody TalentTreeDto talentTreeDto) {
        talentTreeService.talentTreeEditUpdate(id, talentTreeDto);
    }

    @GetMapping("/all")
    public List<TalentTreeDto> findAll() {
        return talentTreeService.FindAllTrees();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(talentTreeService.FindAllTrees().stream().map(TalentTreeDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<TalentTree> talentTrees) throws JsonProcessingException {
        return objectMapper.writeValueAsString(talentTrees);
    }
}
