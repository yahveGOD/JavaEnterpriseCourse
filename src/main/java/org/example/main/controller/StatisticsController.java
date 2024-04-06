package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.RoleDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.entity.Role;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.entity.Statistics;
import org.example.main.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;
    private final JsonMapper jsonMapper;
    @PostMapping("/create")
    public void create(String jsonString) {
        StatisticsDto statisticsDto = jsonMapper.convertFromJsonString(jsonString, StatisticsDto.class);
        statisticsService.addStatistics(statisticsDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        statisticsService.deleteStatistics(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        StatisticsDto statisticsDto = jsonMapper.convertFromJsonString(jsonString, StatisticsDto.class);
        statisticsService.statisticsEditUpdate(id, statisticsDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(statisticsService.findAllStats().stream().map(StatisticsDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(statisticsService.findAllStats().stream().map(StatisticsDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Statistics> statisticsList){
        return jsonMapper.convertToJsonString(statisticsList);
    }
}
