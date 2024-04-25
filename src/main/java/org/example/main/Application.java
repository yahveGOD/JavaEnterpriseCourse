package org.example.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.main.controller.AbilityController;
import org.example.main.controller.ItemController;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.JsonMapper;
import org.example.main.repository.AbilityRepository;
import org.example.main.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.main");
    }
}
