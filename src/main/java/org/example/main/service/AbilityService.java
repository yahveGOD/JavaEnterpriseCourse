package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.annotation.Transaction;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.repository.AbilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;
    @Transaction
    public List<AbilityDto> findAll() {
        return abilityRepository.findAll().stream().map(AbilityDtoMapper::convertEntityToDto).toList();
    }
    @Transaction
    public AbilityDto findById(long id) {
        return  AbilityDtoMapper.convertEntityToDto((abilityRepository.findById(id)).orElseThrow(RuntimeException::new));
    }
    @Transaction
    public void delete(long id) {
        abilityRepository.deleteById(id);
    }
    @Transaction
    public void update(long id,AbilityDto abilityDto) {
        Ability ability = abilityRepository.findById((id)).orElseThrow(RuntimeException::new);

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
    @Transaction
    public void addAbility(AbilityDto abilityDto) {
        abilityRepository.save(AbilityDtoMapper.convertDtoToEntity(abilityDto));
    }
    @Transaction
    public void addHero(long id,HeroDto heroDto)
    {
        Ability ability = abilityRepository.findById((id)).orElseThrow(RuntimeException::new);
        ability.setHero(HeroDtoMapper.convertDtoToEntity(heroDto));
        abilityRepository.save(ability);
    }
}
