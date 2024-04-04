package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.ability.AbilityDto;
import org.example.main.dto.hero.HeroDto;
import org.example.main.dto.ability.AbilityDtoMapper;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.repository.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;
    public List<AbilityDto> FindAllAbilities() {
        return abilityRepository.findAll().stream().map(AbilityDtoMapper::convertEntityToDto).toList();
    }
    public void deleteAbility(long idInList) {
        abilityRepository.deleteById(idInList);
    }

    public void abilityEditUpdate(long idInList,AbilityDto abilityDto) {
        Ability ability = abilityRepository.findById(idInList);

        if(abilityDto.getName()!= null)
            ability.setName(abilityDto.getName());
        ability.setPassive(abilityDto.isPassive());
        if(abilityDto.getDescription()!= null)
            ability.setDescription(abilityDto.getDescription());
        if(abilityDto.getFixedDamage()>0)
            ability.setFixedDamage(abilityDto.getFixedDamage());
        if(abilityDto.getDamageType() != null)
            ability.setDamageType(abilityDto.getDamageType());

        abilityRepository.save(ability);
    }

    public void addAbility(AbilityDto abilityDto) {
        abilityRepository.save(AbilityDtoMapper.convertDtoToEntity(abilityDto));
    }

    public void addHero(long id,HeroDto heroDto)
    {
        Ability ability = abilityRepository.findById(id);
        ability.setHero(HeroDtoMapper.convertDtoToEntity(heroDto));
        abilityRepository.save(ability);
    }
}
