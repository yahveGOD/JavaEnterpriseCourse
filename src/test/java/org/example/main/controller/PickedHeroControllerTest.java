package org.example.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.configuration.AppConfig;
import org.example.main.dto.*;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.entity.PickedHeroId;
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
public class PickedHeroControllerTest {

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
        mockMvc.perform(get("/api/v1/picked_hero/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/picked_hero/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        PickedHeroDto pickedHeroDto = PickedHeroDto.builder()
                .pickedHeroId(new PickedHeroId())
                .heroes(new ArrayList<>())
                .matches(new ArrayList<>())
                .user(new UserDto())
                .inventory(new InventoryDto())
                .statistics(new StatisticsDto())
                .build();

        mockMvc.perform(post("/api/v1/picked_hero/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pickedHeroDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        PickedHeroDto dto = new PickedHeroDto();
        dto.setInventory(InventoryDto.builder()
                        .buildEffectivity(0.4f)
                        .build());
        mockMvc.perform(put("/api/v1/picked_hero/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/picked_hero/delete/1/1"))
                .andExpect(status().isOk());
    }
}
