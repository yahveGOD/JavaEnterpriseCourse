package org.example.main.dto.talentTree;

import lombok.experimental.UtilityClass;
import org.example.main.dto.hero.HeroDtoMapper;
import org.example.main.dto.talentTree.TalentTreeDto;
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
                .talentRight(source.getTalentRight())
                .talentLeft(source.getTalentLeft())
                .levelRequired(source.getLevelRequired())
                .build();
    }
}
