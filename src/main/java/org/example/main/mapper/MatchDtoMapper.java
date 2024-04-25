package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.MatchDto;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.entity.Match;

@UtilityClass
public class MatchDtoMapper {
    public static MatchDto convertEntityToDto(Match source)
    {
        return MatchDto.builder()
               .id(source.getId())
               .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameModeDtoMapper.convertEntityToDto(source.getGameMode()))
                .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .users(source.getUsers().stream().map(UserDtoMapper::convertEntityToDto).toList())
                .replay(ReplayDtoMapper.convertEntityToDto(source.getReplay()))
                .build();
    }

    public static Match convertDtoToEntity(MatchDto source)
    {
        return Match.builder()
              //  .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameModeDtoMapper.convertDtoToEntity(source.getGameMode()))
               // .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .users(source.getUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList())
                .replay(ReplayDtoMapper.convertDtoToEntity(source.getReplay()))
                .build();
    }
}
