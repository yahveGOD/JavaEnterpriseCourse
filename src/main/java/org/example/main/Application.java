package org.example.main;

import org.example.main.controller.AbilityController;
import org.example.main.controller.PickedHeroController;
import org.example.main.dto.ability.AbilityDto;
import org.example.main.dto.hero.HeroDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.main");
        AbilityController abilityController  = context.getBean(AbilityController.class);
        AbilityDto abilityDto = new AbilityDto(1, new HeroDto(0,"zxc",0.5f,0.4f,11,11,11,11), "1", "1", "1", 123, true);

        abilityController.deleteById(2);
        abilityController.EditUpdate(1,abilityDto);

        System.out.println(abilityController.getJson());
    }
}
