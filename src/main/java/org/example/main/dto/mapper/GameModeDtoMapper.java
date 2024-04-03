package org.example.main.dto.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.GameModeDto;
import org.example.main.entity.GameMode;

@UtilityClass
public class GameModeDtoMapper {
    public static GameModeDto convertEntityToDto(GameMode source){
        return GameModeDto.builder()
                .uuid(source.getId())
                .description(source.getDescription())
                .isEvent(source.isEvent())
                .name(source.getName())
                .numberOfPLayers(source.getNumberOfPLayers())
                .build();
    }

    public  static GameMode convertDtoToEntity(GameModeDto source)
    {
        return GameMode.builder()
                .id(source.getUuid())
                .description(source.getDescription())
                .isEvent(source.isEvent())
                .name(source.getName())
                .numberOfPLayers(source.getNumberOfPLayers())
                .build();
    }
}
