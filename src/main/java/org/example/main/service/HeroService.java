package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository heroRepository;

    public List<HeroDto> findAll() {
        return heroRepository.findAll().stream().map(HeroDtoMapper::convertEntityToDto).toList();
    }

    public void delete(Long id) {
        heroRepository.deleteById(id);
    }

    public void update(Long id, HeroDto heroDto) {
        Hero hero = heroRepository.findById(id);

        hero.setName(heroDto.getName());
        hero.setAgility(heroDto.getAgility());
        hero.setIntelligence(heroDto.getIntelligence());
        hero.setStrength(heroDto.getStrength());
        hero.setPickedTimes(heroDto.getPickedTimes());
        hero.setWinRate(heroDto.getWinRate());
        hero.setPickRate(heroDto.getPickRate());
        hero.setPickedHeroes(heroDto.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());
        hero.setAbilities(heroDto.getAbilities().stream().map(AbilityDtoMapper::convertDtoToEntity).toList());

        heroRepository.update(hero);
    }

    public void addHero(HeroDto heroDto) {
        heroRepository.create(HeroDtoMapper.convertDtoToEntity(heroDto));
    }
}
