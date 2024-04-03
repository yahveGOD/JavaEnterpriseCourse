package org.example.main.dto.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.MatchDto;
import org.example.main.entity.Match;

@UtilityClass
public class MatchDtoMapper {
    public static MatchDto convertEntityToDto(Match source)
    {
        return MatchDto.builder()
                .uuid(source.getId())
                .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameModeDtoMapper.convertEntityToDto(source.getGameMode()))
                .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .build();
    }

    public static Match convertDtoToEntity(MatchDto source)
    {
        return Match.builder()
                .id(source.getUuid())
                .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameModeDtoMapper.convertDtoToEntity(source.getGameMode()))
                .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .build();
    }
}
