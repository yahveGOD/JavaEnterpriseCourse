package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.HeroDto;
import org.example.main.dto.creationDto.AbilityCreationDto;
import org.example.main.dto.AbilityDto;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;

@UtilityClass
public class AbilityDtoMapper {
    public static AbilityDto convertEntityToDto(Ability source)
    {
        return AbilityDto.builder()
                .id(source.getId())
                .damageType(source.getDamageType())
                .description(source.getDescription())
                .fixedDamage(source.getFixedDamage())
                .hero(HeroDto.builder()
                        .id(source.getHero().getId())
                        .name(source.getHero().getName())
                        .build())
                .name(source.getName())
                .isPassive(source.getIsPassive())
                .build();
    }

    public static Ability convertDtoToEntity(AbilityDto source)
    {
        return Ability.builder()
                .damageType(source.getDamageType())
                .description(source.getDescription())
                .fixedDamage(source.getFixedDamage())
                .hero(Hero.builder()
                        .id(source.getHero().getId())
                        .name(source.getHero().getName())
                        .build())
                .name(source.getName())
                .isPassive(source.getIsPassive())
                .build();
    }

    public static Ability buildEntity(AbilityCreationDto source){
        return Ability.builder()
                .name(source.getName())
                .damageType(source.getDamageType())
                .description(source.getDescription())
                .isPassive(source.getIsPassive())
                .fixedDamage(source.getFixedDamage())
                .build();
    }
}
