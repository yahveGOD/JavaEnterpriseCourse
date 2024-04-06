package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.entity.GameMode;
import org.example.main.repository.GameModeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameModeService {
    private final GameModeRepository gameModeRepository;

    public List<GameModeDto> findAllGameModes(){
        return gameModeRepository.findAll().stream().map(GameModeDtoMapper::convertEntityToDto).toList();
    }

    public void deleteGameMode(int idInList) {
        gameModeRepository.deleteById(idInList);
    }

    public void gameModeEditUpdate(int idInList, GameModeDto gameModeDto) {
        GameMode gameMode = gameModeRepository.findById(idInList);

        gameMode.setDescription(gameModeDto.getDescription());
        gameMode.setName(gameModeDto.getName());
        gameMode.setEvent(gameModeDto.isEvent());
        gameMode.setNumberOfPLayers(gameModeDto.getNumberOfPLayers());

        gameModeRepository.save(gameMode);
    }

    public void addGameMode(GameModeDto gameModeDto) {
        gameModeRepository.save(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
    }
}
