package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.MatchDto;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.entity.Match;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.mapper.UserDtoMapper;
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

    public void delete(Long id) {
        matchRepository.findById(id);
    }

    public void update(Long id, MatchDto matchDto) {
        Match match = matchRepository.findById(id);

        match.setDuration(matchDto.getDuration());
        match.setDireKills(matchDto.getDireKills());
        match.setVictorySide(matchDto.getVictorySide());
        match.setRadiantKills(matchDto.getRadiantKills());
        match.setReplay(ReplayDtoMapper.convertDtoToEntity(matchDto.getReplay()));
        match.setUsers(matchDto.getUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());
        match.setGameMode(GameModeDtoMapper.convertDtoToEntity(matchDto.getGameMode()));

        matchRepository.update(match);
    }

    public void addMatch(MatchDto matchDto) {
        matchRepository.create(MatchDtoMapper.convertDtoToEntity(matchDto));
    }

    public void addGameMode(long id, GameModeDto gameModeDto)
    {
        Match match = matchRepository.findById(id);
        match.setGameMode(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
        matchRepository.create(match);
    }

}
