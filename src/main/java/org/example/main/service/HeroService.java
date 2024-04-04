package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.hero.HeroDto;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository heroRepository;

    public List<HeroDto> FindAllHeroes() {
        return heroRepository.findAll().stream().map(HeroDtoMapper::convertEntityToDto).toList();
    }

    public void deleteHero(int idInList) {
        heroRepository.deleteById(idInList);
    }

    public void heroEditUpdate(int idInList, HeroDto heroDto) {
        Hero hero = heroRepository.findById(idInList);

        hero.setName(heroDto.getName());
        hero.setAgility(heroDto.getAgility());
        hero.setIntelligence(heroDto.getIntelligence());
        hero.setStrength(heroDto.getStrength());
        hero.setPickedTimes(heroDto.getPickedTimes());
        hero.setWinRate(heroDto.getWinRate());
        hero.setPickRate(heroDto.getPickRate());

        heroRepository.save(hero);
    }

    public void addHero(HeroDto heroDto) {
        heroRepository.save(HeroDtoMapper.convertDtoToEntity(heroDto));
    }
}
