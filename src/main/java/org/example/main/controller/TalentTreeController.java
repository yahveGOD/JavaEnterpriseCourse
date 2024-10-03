package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.entity.Statistics;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.entity.TalentTree;
import org.example.main.service.TalentTreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/talent_tree")
@RequiredArgsConstructor
public class TalentTreeController {
    private final TalentTreeService talentTreeService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(@RequestBody TalentTreeDto talentTreeDto) {
        talentTreeService.addTalentTree(talentTreeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        talentTreeService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public void editUpdate(@PathVariable("id") Long id, TalentTreeDto talentTreeDto) {
        talentTreeService.update(id, talentTreeDto);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id)
    {
        String json = jsonMapper.convertToJsonString(talentTreeService.findById(id));
        return json;
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(talentTreeService.findAll().stream().map(TalentTreeDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(talentTreeService.findAll().stream().map(TalentTreeDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<TalentTree> talentTrees)  {
        return jsonMapper.convertToJsonString(talentTrees);
    }
}
