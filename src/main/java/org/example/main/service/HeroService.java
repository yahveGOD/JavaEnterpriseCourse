package org.example.main.service;

import org.example.main.dto.GameModeDto;
import org.example.main.dto.HeroDto;
import org.example.main.dto.mapper.GameModeDtoMapper;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.entity.GameMode;
import org.example.main.entity.Hero;
import org.example.main.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HeroService {
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<HeroDto> FindAllHeroes() {
        return heroRepository.getHeroes().stream().map(HeroDtoMapper::convertEntityToDto).toList();
    }

    public void deleteHero(int idInList) {
        heroRepository.getHeroes().remove(idInList);
    }

    public void heroEditUpdate(int idInList, HeroDto heroDto) {
        Hero hero = heroRepository.getHeroes().get(idInList);
        hero.setId(heroDto.getUuid());
        hero.setName(heroDto.getName());
        hero.setAgility(heroDto.getAgility());
        hero.setIntelligence(heroDto.getIntelligence());
        hero.setStrength(heroDto.getStrength());
        hero.setPickedTimes(heroDto.getPickedTimes());
        hero.setWinRate(heroDto.getWinRate());
        hero.setPickRate(heroDto.getPickRate());
        heroRepository.getHeroes().set(idInList, hero);
    }

    public void addHero(HeroDto heroDto) {
        heroRepository.getHeroes().add(HeroDtoMapper.convertDtoToEntity(heroDto));
    }

}
