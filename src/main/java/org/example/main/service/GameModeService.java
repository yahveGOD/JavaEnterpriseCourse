package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.entity.GameMode;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.repository.GameModeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameModeService {
    private final GameModeRepository gameModeRepository;

    public List<GameModeDto> findAll(){
        return gameModeRepository.findAll().stream().map(GameModeDtoMapper::convertEntityToDto).toList();
    }

    public void delete(Long id) {
        gameModeRepository.deleteById(id);
    }

    public void update(Long id, GameModeDto gameModeDto) {
        GameMode gameMode = gameModeRepository.findById(id);

        gameMode.setDescription(gameModeDto.getDescription());
        gameMode.setName(gameModeDto.getName());
       // gameMode.setIsEvent(gameModeDto.getIsEvent());
        //gameMode.setNumberOfPLayers(gameModeDto.getNumberOfPLayers());
        gameMode.setMatches(gameModeDto.getMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList());

        gameModeRepository.update(gameMode);
    }

    public void addGameMode(GameModeDto gameModeDto) {
        gameModeRepository.create(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
    }
}
