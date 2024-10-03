package org.example.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.configuration.AppConfig;
import org.example.main.dto.RoleDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.creationDto.RoleCreationDto;
import org.example.main.dto.creationDto.StatisticsCreationDto;
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
public class StatisticsControllerDto {
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
        mockMvc.perform(get("/api/v1/statistics/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/statistics/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        StatisticsDto statisticsDto = StatisticsDto.builder()
                .pickedHeroList(new ArrayList<>())
                .deaths(11)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();

        mockMvc.perform(post("/api/v1/statistics/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(statisticsDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        StatisticsDto dto = new StatisticsDto();
        dto.setAssists(123123);

        mockMvc.perform(put("/api/v1/statistics/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/statistics/delete/1"))
                .andExpect(status().isOk());
    }
}
