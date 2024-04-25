package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.entity.PickedHeroId;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.dto.PickedHeroDto;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.mapper.UserDtoMapper;
import org.example.main.entity.PickedHero;
import org.example.main.repository.PickedHeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PickedHeroService {
    private final PickedHeroRepository pickedHeroRepository;


    public List<PickedHeroDto> findAll() {
        return pickedHeroRepository.findAll().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList();
    }

    public void delete(Long id) {
        pickedHeroRepository.findAll().remove(id);
    }

    public void update(PickedHeroId pickedHeroId, PickedHeroDto pickedHeroDto) {
        PickedHero pickedHero = pickedHeroRepository.findByPickedHeroId(pickedHeroId);

        pickedHero.setHeroes(pickedHeroDto.getHeroes().stream().map(HeroDtoMapper::convertDtoToEntity).toList());
        pickedHero.setMatches(pickedHeroDto.getMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
        pickedHero.setUser(UserDtoMapper.convertDtoToEntity(pickedHeroDto.getUser()));
        pickedHero.setInventory(InventoryDtoMapper.convertDtoToEntity(pickedHeroDto.getInventory()));
        pickedHero.setStatistics(StatisticsDtoMapper.convertDtoToEntity(pickedHeroDto.getStatistics()));

        pickedHeroRepository.update(pickedHero);
    }

    public void addPickedHero(PickedHeroDto pickedHeroDto) {
        pickedHeroRepository.create(PickedHeroDtoMapper.convertDtoToEntity(pickedHeroDto));
    }
}
