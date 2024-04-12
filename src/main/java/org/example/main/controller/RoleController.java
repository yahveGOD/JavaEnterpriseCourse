package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.RoleDto;
import org.example.main.entity.Replay;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.entity.Role;
import org.example.main.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final JsonMapper jsonMapper;
    @PostMapping("/create")
    public void create(String jsonString) {
        RoleDto roleDto = jsonMapper.convertFromJsonString(jsonString, RoleDto.class);
        roleService.addRole(roleDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        roleService.delete(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        RoleDto roleDto = jsonMapper.convertFromJsonString(jsonString, RoleDto.class);
        roleService.update(id, roleDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(roleService.findAll().stream().map(RoleDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(roleService.findAll().stream().map(RoleDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Role> roles){
        return jsonMapper.convertToJsonString(roles);
    }
}
