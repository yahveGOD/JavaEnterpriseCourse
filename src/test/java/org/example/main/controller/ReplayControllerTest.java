package org.example.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.configuration.AppConfig;
import org.example.main.dto.MatchDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.dto.creationDto.ReplayCreationDto;
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
public class ReplayControllerTest {
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
        mockMvc.perform(get("/api/v1/replay/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/replay/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        ReplayDto replayDto = ReplayDto.builder()
                .match(MatchDto.builder()
                        .id(1L)
                        .radiantKills(1L)
                        .build())
                .steamApiMatchReplayKey(1231231232L)
                .build();

        mockMvc.perform(post("/api/v1/replay/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(replayDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        ReplayDto dto = new ReplayDto();
        dto.setSteamApiMatchReplayKey(11235L);

        mockMvc.perform(put("/api/v1/replay/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/replay/delete/1"))
                .andExpect(status().isOk());
    }
}
