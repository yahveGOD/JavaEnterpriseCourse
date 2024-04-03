package org.example.main.service;

import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.mapper.*;
import org.example.main.entity.PickedHero;
import org.example.main.repository.PickedHeroRepository;

import java.util.List;

public class PickedHeroService {
    private final PickedHeroRepository pickedHeroRepository;

    public PickedHeroService(PickedHeroRepository pickedHeroRepository) {
        this.pickedHeroRepository = pickedHeroRepository;
    }

    public List<PickedHeroDto> FindAllPickedHeroes() {
        return pickedHeroRepository.getPickedHeroList().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList();
    }

    public void deletePickedHero(int idInList) {
        pickedHeroRepository.getPickedHeroList().remove(idInList);
    }

    public void pickedHeroEditUpdate(int idInList, PickedHeroDto pickedHeroDto) {
        PickedHero pickedHero = pickedHeroRepository.getPickedHeroList().get(idInList);
        pickedHero.setHero(HeroDtoMapper.convertDtoToEntity(pickedHeroDto.getHero()));
        pickedHero.setMatch(MatchDtoMapper.convertDtoToEntity(pickedHeroDto.getMatch()));
        pickedHero.setUser(UserDtoMapper.convertDtoToEntity(pickedHeroDto.getUser()));
        pickedHero.setInventory(InventoryDtoMapper.convertDtoToEntity(pickedHeroDto.getInventory()));
        pickedHero.setStatistics(StatisticsDtoMapper.convertDtoToEntity(pickedHeroDto.getStatistics()));
        pickedHeroRepository.getPickedHeroList().set(idInList, pickedHero);
    }

    public void addPickedHero(PickedHeroDto pickedHeroDto) {
        pickedHeroRepository.getPickedHeroList().add(PickedHeroDtoMapper.convertDtoToEntity(pickedHeroDto));
    }
}
