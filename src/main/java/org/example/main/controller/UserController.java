package org.example.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.main.dto.user.UserDto;
import org.example.main.dto.user.UserDtoMapper;
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
    private final ObjectMapper objectMapper;

    @PostMapping("/create")
    public void create(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/edit")
    public void editUpdate(@PathVariable(value = "id") int id, @RequestBody UserDto userDto) {
        userService.userEditUpdate(id, userDto);
    }

    @GetMapping("/all")
    public List<UserDto> findAll() {
        return userService.FindAllUsers();
    }

    public ResponseEntity<String> getJson() {
        try {
            String json = serializeToJson(userService.FindAllUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while serializing object to JSON");
        }
    }

    private String serializeToJson(List<User> users) throws JsonProcessingException {
        return objectMapper.writeValueAsString(users);
    }
}
