package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.creationDto.AbilityCreationDto;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.repository.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public List<AbilityDto> findAll() {
        return abilityRepository.findAll().stream()
                .map(AbilityDtoMapper::convertEntityToDto)
                .toList();
    }

    public AbilityDto findById(Long id) {
        return AbilityDtoMapper.convertEntityToDto(abilityRepository.findById(id));
    }

    public void delete(long id) {
        abilityRepository.deleteById(id);
    }

    public void update(long id, AbilityDto abilityDto) {
        Ability ability = abilityRepository.findById(id);

        if (abilityDto.getName() != null)
            ability.setName(abilityDto.getName());
        ability.setIsPassive(abilityDto.getIsPassive());
        if (abilityDto.getDescription() != null)
            ability.setDescription(abilityDto.getDescription());
        if (abilityDto.getFixedDamage() != null)
            ability.setFixedDamage(abilityDto.getFixedDamage());
        if (abilityDto.getDamageType() != null)
            ability.setDamageType(abilityDto.getDamageType());
        if (abilityDto.getHero() != null)
            ability.setHero(HeroDtoMapper.convertDtoToEntity(abilityDto.getHero()));

        abilityRepository.update(ability);
    }

    public void addAbility(AbilityDto abilityDto) {
        abilityRepository.create(AbilityDtoMapper.convertDtoToEntity(abilityDto));
    }

    public void addAbility(AbilityCreationDto abilityDto) {
        abilityRepository.create(AbilityDtoMapper.buildEntity(abilityDto));
    }

    public void addHero(long id, HeroDto heroDto) {
        Ability ability = abilityRepository.findById(id);
        ability.setHero(HeroDtoMapper.convertDtoToEntity(heroDto));
        abilityRepository.create(ability);
    }
}
