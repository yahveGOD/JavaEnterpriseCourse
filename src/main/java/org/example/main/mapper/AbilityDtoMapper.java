package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.AbilityDto;
import org.example.main.entity.Ability;

@UtilityClass
public class AbilityDtoMapper {
    public static AbilityDto convertEntityToDto(Ability source)
    {
        return AbilityDto.builder()
                .id(source.getId())
                .damageType(source.getDamageType())
                .description(source.getDescription())
                .fixedDamage(source.getFixedDamage())
                .hero(HeroDtoMapper.convertEntityToDto(source.getHero()))
                .name(source.getName())
                .isPassive(source.isPassive())
                .build();
    }

    public static Ability convertDtoToEntity(AbilityDto source)
    {
        return Ability.builder()
                .damageType(source.getDamageType())
                .description(source.getDescription())
                .fixedDamage(source.getFixedDamage())
                .hero(HeroDtoMapper.convertDtoToEntity(source.getHero()))
                .name(source.getName())
                .isPassive(source.isPassive())
                .build();
    }
}
