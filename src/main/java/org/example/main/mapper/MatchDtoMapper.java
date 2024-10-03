package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.dto.MatchDto;
import org.example.main.entity.GameMode;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;
import org.example.main.entity.User;

import java.util.stream.Collectors;

@UtilityClass
public class MatchDtoMapper {
    public static MatchDto convertEntityToDto(Match source)
    {
        return MatchDto.builder()
               .id(source.getId())
               .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameModeDto.builder()
                        .id(source.getGameMode().getId())
                        .name(source.getGameMode().getName())
                        .build())
                .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .users(source.getUsers().stream()
                        .map(user -> UserDto.builder()
                                .name(user.getName())
                                .id(user.getId())
                                .build())
                        .toList())
                .replay(ReplayDto.builder()
                        .id(source.getReplay().getId())
                        .steamApiMatchReplayKey(source.getReplay().getSteamApiMatchReplayKey())
                        .build())
                .build();
    }

    public static Match convertDtoToEntity(MatchDto source)
    {
        return Match.builder()
                .direKills(source.getDireKills())
                .duration(source.getDuration())
                .gameMode(GameMode.builder()
                        .id(source.getGameMode().getId())
                        .name(source.getGameMode().getName())
                        .build())
                .radiantKills(source.getRadiantKills())
                .victorySide(source.getVictorySide())
                .users(source.getUsers().stream()
                        .map(userDto -> User.builder()
                                .name(userDto.getName())
                                .id(userDto.getId())
                                .build())
                        .collect(Collectors.toList()))
                .replay(Replay.builder()
                        .id(source.getReplay().getId())
                        .steamApiMatchReplayKey(source.getReplay().getSteamApiMatchReplayKey())
                        .build())
                .build();
    }

    public static Match buildEntity(MatchCreationDto source){
        return Match.builder()
                .radiantKills(source.getRadiantKills())
                .duration(source.getDuration())
                .direKills(source.getDireKills())
                .victorySide(source.getVictorySide())
                .build();
    }
}
