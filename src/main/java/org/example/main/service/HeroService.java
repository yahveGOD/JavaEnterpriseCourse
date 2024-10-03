package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.creationDto.HeroCreationDto;
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
        if (heroDto.getName() != null)
            hero.setName(heroDto.getName());
        if (heroDto.getAgility() >= 0)
            hero.setAgility(heroDto.getAgility());
        if (heroDto.getIntelligence() >= 0)
            hero.setIntelligence(heroDto.getIntelligence());
        if (heroDto.getStrength() >= 0)
            hero.setStrength(heroDto.getStrength());
        if (heroDto.getPickedTimes() >= 0)
            hero.setPickedTimes(heroDto.getPickedTimes());
        if (heroDto.getWinRate() >= 0)
            hero.setWinRate(heroDto.getWinRate());
        if (heroDto.getPickRate() >= 0)
            hero.setPickRate(heroDto.getPickRate());
        if (heroDto.getPickedHeroes() != null)
            hero.setPickedHeroes(heroDto.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());
        if (heroDto.getAbilities() != null)
            hero.setAbilities(heroDto.getAbilities().stream().map(AbilityDtoMapper::convertDtoToEntity).toList());

        heroRepository.update(hero);
    }

    public void addHero(HeroDto heroDto) {
        heroRepository.create(HeroDtoMapper.convertDtoToEntity(heroDto));
    }

    public void addHero(HeroCreationDto heroDto) {
        heroRepository.create(HeroDtoMapper.buildEntity(heroDto));
    }

    public HeroDto findById(Long id) {
        return HeroDtoMapper.convertEntityToDto(heroRepository.findById(id));
    }

}
