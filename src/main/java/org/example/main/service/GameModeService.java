package org.example.main.service;

import org.example.main.dto.AbilityDto;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.mapper.AbilityDtoMapper;
import org.example.main.dto.mapper.GameModeDtoMapper;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.entity.Ability;
import org.example.main.entity.GameMode;
import org.example.main.repository.GameModeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameModeService {
    private final GameModeRepository gameModeRepository;

    public GameModeService(GameModeRepository gameModeRepository) {
        this.gameModeRepository = gameModeRepository;
    }

    public List<GameModeDto> FindAllGameModes(){
        return gameModeRepository.getGameModeList().stream().map(GameModeDtoMapper::convertEntityToDto).toList();
    }

    public void deleteGameMode(int idInList) {
        gameModeRepository.getGameModeList().remove(idInList);
    }

    public void gameModeEditUpdate(int idInList, GameModeDto gameModeDto) {
        GameMode gameMode = gameModeRepository.getGameModeList().get(idInList);
        gameMode.setDescription(gameModeDto.getDescription());
        gameMode.setId(gameModeDto.getUuid());
        gameMode.setName(gameModeDto.getName());
        gameMode.setEvent(gameModeDto.isEvent());
        gameMode.setNumberOfPLayers(gameModeDto.getNumberOfPLayers());
        gameModeRepository.getGameModeList().set(idInList, gameMode);
    }

    public void addGameMode(GameModeDto gameModeDto) {
        gameModeRepository.getGameModeList().add(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
    }
}
