package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.MatchDto;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.mapper.MatchDtoMapper;
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

    public void delete(int idInList) {
        matchRepository.findById(idInList);
    }

    public void update(int idInList, MatchDto matchDto) {
        Match match = matchRepository.findById(idInList);

        match.setDuration(matchDto.getDuration());
        match.setDireKills(matchDto.getDireKills());
        match.setVictorySide(matchDto.getVictorySide());
        match.setRadiantKills(matchDto.getRadiantKills());

        matchRepository.save(match);
    }

    public void addMatch(MatchDto matchDto) {
        matchRepository.save(MatchDtoMapper.convertDtoToEntity(matchDto));
    }

    public void addGameMode(long id, GameModeDto gameModeDto)
    {
        Match match = matchRepository.findById(id);
        match.setGameMode(GameModeDtoMapper.convertDtoToEntity(gameModeDto));
        matchRepository.save(match);
    }

}
