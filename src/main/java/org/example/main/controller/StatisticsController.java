package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.RoleDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.StatisticsDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Statistics;
import org.example.main.service.RoleService;
import org.example.main.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody StatisticsDto statisticsDto) {
        statisticsService.addStatistics(statisticsDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        statisticsService.deleteStatistics(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody StatisticsDto statisticsDto) {
        statisticsService.statisticsEditUpdate(id, statisticsDto);
    }

    @GetMapping("/all")
    public List<StatisticsDto> findAll() {
        return statisticsService.FindAllStats();
    }

    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(statisticsService.FindAllStats().stream().map(StatisticsDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Statistics> statistics) throws JsonProcessingException {
        return objectMapper.writeValueAsString(statistics);
    }
}
