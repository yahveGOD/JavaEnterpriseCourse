package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.RoleDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.Role;
import org.example.main.service.ReplayService;
import org.example.main.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody RoleDto roleDto) {
        roleService.addRole(roleDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        roleService.deleteRole(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody RoleDto roleDto) {
        roleService.roleEditUpdate(id, roleDto);
    }

    @GetMapping("/all")
    public List<RoleDto> findAll() {
        return roleService.FindAllRoles();
    }
    @GetMapping("/serialize")
    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(roleService.FindAllRoles().stream().map(RoleDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<Role> roles) throws JsonProcessingException {
        return objectMapper.writeValueAsString(roles);
    }
}
