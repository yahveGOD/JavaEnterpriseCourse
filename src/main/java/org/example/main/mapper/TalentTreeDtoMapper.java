package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.HeroDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.entity.Hero;
import org.example.main.entity.TalentTree;
@UtilityClass
public class TalentTreeDtoMapper {
    public static TalentTreeDto convertEntityToDto(TalentTree source)
    {
        return TalentTreeDto.builder()
                .hero(HeroDto.builder()
                        .id(source.getHero().getId())
                        .name(source.getHero().getName())
                        .build())
                .id(source.getId())
                //.talentBranch(source.getTalentBranch())
                .levelRequired(source.getLevelRequired())
                .cells(source.getCells())
                .build();
    }

    public static TalentTree convertDtoToEntity(TalentTreeDto source)
    {
        return TalentTree.builder()
                .hero(Hero.builder()
                        .name(source.getHero().getName())
                        .id(source.getHero().getId())
                        .build())
                //.talentBranch(source.getTalentBranch())
                .levelRequired(source.getLevelRequired())
                .cells(source.getCells())
                .build();
    }

    public static TalentTree buildEntity(TalentTreeCreationDto source){
        return TalentTree.builder()

                //.talentBranch(source.getTalentBranch())
                .levelRequired(source.getLevelRequired())
                .build();
    }
}
