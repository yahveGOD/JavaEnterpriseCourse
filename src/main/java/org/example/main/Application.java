package org.example.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.controller.AbilityController;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.JsonMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.main");
        AbilityController abilityController  = context.getBean(AbilityController.class);
        JsonMapper jsonMapper = new JsonMapper(new ObjectMapper());
        AbilityDto abilityDto = new AbilityDto(1, new HeroDto(0,"zxc",0.5f,0.4f,11,11,11,11), "1", "1", "1", 123, true);
        String json = jsonMapper.convertToJsonString(abilityDto);

        abilityController.deleteById(2);
        abilityController.editUpdate(1,json);

        System.out.println(abilityController.getJson());
    }
}
