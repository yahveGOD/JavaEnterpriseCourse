package org.example.main.dto.replay;

import lombok.experimental.UtilityClass;
import org.example.main.dto.match.MatchDtoMapper;
import org.example.main.dto.replay.ReplayDto;
import org.example.main.entity.Replay;

@UtilityClass
public class ReplayDtoMapper {
    public static ReplayDto convertEntityToDto(Replay source)
    {
        return ReplayDto.builder()
                .match(MatchDtoMapper.convertEntityToDto(source.getMatch()))
                .uuid(source.getId())
                .steamApiMatchReplayKey(source.getSteamApiMatchReplayKey())
                .build();
    }

    public static Replay convertDtoToEntity(ReplayDto source)
    {
        return Replay.builder()
                .match(MatchDtoMapper.convertDtoToEntity(source.getMatch()))
                .steamApiMatchReplayKey(source.getSteamApiMatchReplayKey())
                .build();
    }
}
