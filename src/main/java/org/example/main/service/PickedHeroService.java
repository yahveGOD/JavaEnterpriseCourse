package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.dto.inventory.InventoryDtoMapper;
import org.example.main.dto.match.MatchDtoMapper;
import org.example.main.dto.pickedHero.PickedHeroDto;
import org.example.main.dto.pickedHero.PickedHeroDtoMapper;
import org.example.main.dto.statistics.StatisticsDtoMapper;
import org.example.main.dto.user.UserDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.entity.Match;
import org.example.main.entity.PickedHero;
import org.example.main.repository.PickedHeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PickedHeroService {
    private final PickedHeroRepository pickedHeroRepository;


    public List<PickedHeroDto> FindAllPickedHeroes() {
        return pickedHeroRepository.findAll().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList();
    }

    public void deletePickedHero(int idInList) {
        pickedHeroRepository.findAll().remove(idInList);
    }

    public void pickedHeroEditUpdate(Hero hero, Match match, PickedHeroDto pickedHeroDto) {
        PickedHero pickedHero = pickedHeroRepository.findByMatchAndHero(match,hero);

        pickedHero.setHero(HeroDtoMapper.convertDtoToEntity(pickedHeroDto.getHero()));
        pickedHero.setMatch(MatchDtoMapper.convertDtoToEntity(pickedHeroDto.getMatch()));
        pickedHero.setUser(UserDtoMapper.convertDtoToEntity(pickedHeroDto.getUser()));
        pickedHero.setInventory(InventoryDtoMapper.convertDtoToEntity(pickedHeroDto.getInventory()));
        pickedHero.setStatistics(StatisticsDtoMapper.convertDtoToEntity(pickedHeroDto.getStatistics()));

        pickedHeroRepository.save(pickedHero);
    }

    public void addPickedHero(PickedHeroDto pickedHeroDto) {
        pickedHeroRepository.save(PickedHeroDtoMapper.convertDtoToEntity(pickedHeroDto));
    }
}
