package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.TalentTreeDto;
import org.example.main.entity.TalentTree;
@UtilityClass
public class TalentTreeDtoMapper {
    public static TalentTreeDto convertEntityToDto(TalentTree source)
    {
        return TalentTreeDto.builder()
                .hero(HeroDtoMapper.convertEntityToDto(source.getHero()))
                .id(source.getId())
                .talentBranch(source.getTalentBranch())
                .levelRequired(source.getLevelRequired())
                .build();
    }

    public static TalentTree convertDtoToEntity(TalentTreeDto source)
    {
        return TalentTree.builder()
                .hero(HeroDtoMapper.convertDtoToEntity(source.getHero()))
                .talentBranch(source.getTalentBranch())
                .levelRequired(source.getLevelRequired())
                .build();
    }
}
