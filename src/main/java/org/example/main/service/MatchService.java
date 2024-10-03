package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.dto.MatchDto;
import org.example.main.mapper.*;
import org.example.main.entity.Match;
import org.example.main.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;

    public List<MatchDto> findAll() {
        return matchRepository.findAll().stream().map(MatchDtoMapper::convertEntityToDto).toList();
    }

    public MatchDto findById(Long id) {
        return MatchDtoMapper.convertEntityToDto(matchRepository.findById(id));
    }

    public void delete(Long id) {
        matchRepository.findById(id);
    }

    public void update(Long id, MatchDto matchDto) {
        Match match = matchRepository.findById(id);
        if (matchDto.getDuration() != null)
            match.setDuration(matchDto.getDuration());
        if (matchDto.getDireKills() != null)
            match.setDireKills(matchDto.getDireKills());
        if (matchDto.getVictorySide() != null)
            match.setVictorySide(matchDto.getVictorySide());
        if (matchDto.getRadiantKills() != null)
            match.setRadiantKills(matchDto.getRadiantKills());
        if (matchDto.getReplay() != null)
            match.setReplay(ReplayDtoMapper.convertDtoToEntity(matchDto.getReplay()));
        if (matchDto.getUsers() != null)
            match.setUsers(matchDto.getUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());
        if (matchDto.getGameMode() != null)
            match.setGameMode(GameModeDtoMapper.convertDtoToEntity(matchDto.getGameMode()));

        matchRepository.update(match);
    }

    public void addMatch(MatchDto matchDto) {
        matchRepository.create(MatchDtoMapper.convertDtoToEntity(matchDto));
    }

    public void addMatch(MatchCreationDto matchDto) {
        matchRepository.create(MatchDtoMapper.buildEntity(matchDto));
    }

    public void addGameMode(long id, GameModeDto gameModeDto) {
        Match match = matchRepository.findById(id);
        match.setGameMode(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
        matchRepository.create(match);
    }

}
