package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.MatchDto;
import org.example.main.dto.creationDto.GameModeCreationDto;
import org.example.main.dto.GameModeDto;
import org.example.main.entity.GameMode;
import org.example.main.entity.Match;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class GameModeDtoMapper {
    public static GameModeDto convertEntityToDto(GameMode source){
        return GameModeDto.builder()
                .id(source.getId())
                .description(source.getDescription())
                .isEvent(source.getIsEvent())
                .name(source.getName())
                .numberOfPLayers(source.getNumberOfPLayers())
                .matches(source.getMatches().stream()
                        .map(match -> MatchDto.builder()
                                .id(match.getId())
                                .build())
                        .toList())
                .build();
    }

    public  static GameMode convertDtoToEntity(GameModeDto source)
    {
        return GameMode.builder()
                .description(source.getDescription())
                .isEvent(source.getIsEvent())
                .name(source.getName())
                .numberOfPLayers(source.getNumberOfPLayers())
                .matches(source.getMatches().stream()
                        .map(matchDto -> Match.builder()
                                .id(matchDto.getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static GameMode buildEntity(GameModeCreationDto source){
        return GameMode.builder()
                .name(source.getName())
                .description(source.getDescription())
                .isEvent(source.getIsEvent())
                .numberOfPLayers(source.getNumberOfPLayers())
                .build();
    }
}
