package org.example.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.controller.AbilityController;
import org.example.main.controller.ItemController;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.JsonMapper;
import org.example.main.util.ConnectionHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.main");
        JsonMapper jsonMapper = new JsonMapper(new ObjectMapper());
        AbilityDto abilityDto = new AbilityDto(1, new HeroDto(0,"zxc",0.5f,0.4f,11,11,11,11), "1", "1", "1", 123, true);
        ConnectionHolder connectionHolder = context.getBean(ConnectionHolder.class);

        Runnable task  = () -> {
            AbilityController abilityController  = context.getBean(AbilityController.class);
            System.out.println(abilityController.findById(2));

        };

        Runnable task1  = () -> {
            ItemController itemController = context.getBean(ItemController.class);

            itemController.deleteById(1);

            System.out.println(itemController.findAll());


        };

        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task1);
        thread.start();
        thread1.start();
    }
}
