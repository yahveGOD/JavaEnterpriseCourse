package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.MatchDto;
import org.example.main.dto.creationDto.ReplayCreationDto;
import org.example.main.dto.ReplayDto;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;

@UtilityClass
public class ReplayDtoMapper {
    public static ReplayDto convertEntityToDto(Replay source)
    {
        return ReplayDto.builder()
                .match(MatchDto.builder()
                        .id(source.getMatch().getId())
                        .radiantKills(source.getMatch().getRadiantKills())
                        .build())
                .id(source.getId())
                .steamApiMatchReplayKey(source.getSteamApiMatchReplayKey())
                .build();
    }

    public static Replay convertDtoToEntity(ReplayDto source)
    {
        return Replay.builder()
                .match(Match.builder()
                        .id(source.getMatch().getId())
                        .radiantKills(source.getMatch().getRadiantKills())
                        .build())
                .steamApiMatchReplayKey(source.getSteamApiMatchReplayKey())
                .build();
    }

    public static Replay buildEntity(ReplayCreationDto source){
        return Replay.builder()
                .steamApiMatchReplayKey(source.getSteamApiMatchReplayKey())
                .build();
    }
}
