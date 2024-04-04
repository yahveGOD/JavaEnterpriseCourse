package org.example.main.dto.ability;

import lombok.experimental.UtilityClass;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.entity.Ability;

@UtilityClass
public class AbilityDtoMapper {
    public static AbilityDto convertEntityToDto(Ability source)
    {
        return AbilityDto.builder()
                .uuid(source.getId())
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
