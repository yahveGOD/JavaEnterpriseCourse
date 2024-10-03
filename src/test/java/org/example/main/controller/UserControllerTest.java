package org.example.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.configuration.AppConfig;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.dto.creationDto.UserCreationDto;
import org.example.main.entity.TalentBranch;
import org.example.main.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes ={AppConfig.class},
        loader = AnnotationConfigWebContextLoader.class
)
@WebAppConfiguration
@Transactional
public class UserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void findAllTest() throws Exception{
        mockMvc.perform(get("/api/v1/user/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        UserDto userDto = UserDto.builder()
                .steamApiKey("zxcxzc")
                .roles(new ArrayList<>())
                .matches(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .name("qwe")
                .password("xczxc")
                .description("qweqwe")
                .averageMatchmakingRating(1231)
                .build();

        mockMvc.perform(post("/api/v1/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        UserDto dto = new UserDto();
        dto.setName(":zxc");

        mockMvc.perform(put("/api/v1/user/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/user/delete/1"))
                .andExpect(status().isOk());
    }
}
