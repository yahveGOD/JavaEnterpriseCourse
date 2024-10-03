package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.UserDto;
import org.example.main.entity.TalentTree;
import org.example.main.mapper.JsonMapper;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.mapper.UserDtoMapper;
import org.example.main.entity.User;
import org.example.main.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.delete(id);

    }

    @PutMapping("/edit/{id}")
    public void editUpdate(@PathVariable("id") Long id, UserDto userDto) {
        userService.update(id, userDto);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id)
    {
        String json = jsonMapper.convertToJsonString(userService.findById(id));
        return json;
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(userService.findAll().stream().map(UserDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(userService.findAll().stream().map(UserDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<User> users){
        return jsonMapper.convertToJsonString(users);
    }
}
