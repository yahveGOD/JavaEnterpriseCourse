package org.example.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.configuration.AppConfig;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.dto.creationDto.AbilityCreationDto;
import org.example.main.entity.Hero;
import org.example.main.repository.AbilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes ={AppConfig.class},
        loader = AnnotationConfigWebContextLoader.class
)
@Transactional
@WebAppConfiguration
public class AbilityControllerTest {
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
        mockMvc.perform(get("/api/v1/ability/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/ability/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        AbilityDto abilityDto = AbilityDto.builder()
                .name("zxc")
                .id(1L)
                .description("z")
                .damageType("qwe")
                .hero(HeroDto.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .isPassive(true)
                .fixedDamage(1000)
                .build();

        mockMvc.perform(post("/api/v1/ability/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(abilityDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateTest() throws Exception {
        AbilityDto dto = new AbilityDto();
        dto.setName("ASDASD");
        dto.setHero(new HeroDto());

        mockMvc.perform(put("/api/v1/ability/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/ability/delete/1"))
                .andExpect(status().isOk());
    }
}
