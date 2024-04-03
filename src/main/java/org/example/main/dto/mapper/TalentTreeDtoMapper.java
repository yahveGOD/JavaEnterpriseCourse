package org.example.main.dto.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.TalentTreeDto;
import org.example.main.entity.TalentTree;
@UtilityClass
public class TalentTreeDtoMapper {
    public static TalentTreeDto convertEntityToDto(TalentTree source)
    {
        return TalentTreeDto.builder()
                .hero(HeroDtoMapper.convertEntityToDto(source.getHero()))
                .uuid(source.getId())
                .talentRight(source.getTalentRight())
                .talentLeft(source.getTalentLeft())
                .levelRequired(source.getLevelRequired())
                .build();
    }

    public static TalentTree convertDtoToEntity(TalentTreeDto source)
    {
        return TalentTree.builder()
                .hero(HeroDtoMapper.convertDtoToEntity(source.getHero()))
                .id(source.getUuid())
                .talentRight(source.getTalentRight())
                .talentLeft(source.getTalentLeft())
                .levelRequired(source.getLevelRequired())
                .build();
    }
}
