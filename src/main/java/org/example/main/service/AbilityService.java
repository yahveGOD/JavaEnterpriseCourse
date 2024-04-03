package org.example.main.service;

import org.example.main.dto.AbilityDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.repository.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public AbilityService(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    public List<AbilityDto> FindAllAbilities() {
        return abilityRepository.getAbilities().stream().map(AbilityDtoMapper::convertEntityToDto).toList();
    }
    public void deleteAbility(int idInList) {
        abilityRepository.getAbilities().remove(idInList);
    }

    public void abilityEditUpdate(int idInList,AbilityDto abilityDto) {
        Ability ability = abilityRepository.getAbilities().get(idInList);
        ability.setName(abilityDto.getName());
        ability.setId(abilityDto.getUuid());
        ability.setHero(HeroDtoMapper.convertDtoToEntity(abilityDto.getHero()));
        ability.setPassive(abilityDto.isPassive());
        ability.setDescription(abilityDto.getDescription());
        ability.setFixedDamage(abilityDto.getFixedDamage());
        ability.setDamageType(abilityDto.getDamageType());
        abilityRepository.getAbilities().set(idInList,ability);
    }

    public void addAbility(AbilityDto abilityDto) {
        abilityRepository.getAbilities().add(AbilityDtoMapper.convertDtoToEntity(abilityDto));
    }


}
