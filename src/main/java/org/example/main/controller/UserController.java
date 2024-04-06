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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JsonMapper jsonMapper;

    @PostMapping("/create")
    public void create(String jsonString) {
        UserDto userDto = jsonMapper.convertFromJsonString(jsonString,UserDto.class);
        userService.addUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);

    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, String jsonString) {
        UserDto userDto = jsonMapper.convertFromJsonString(jsonString,UserDto.class);
        userService.userEditUpdate(id, userDto);
    }

    @GetMapping("/all")
    public String findAll() {
        String json = jsonMapper.convertToJsonString(userService.findAllUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());
        return json;
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(userService.findAllUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<User> users){
        return jsonMapper.convertToJsonString(users);
    }
}
