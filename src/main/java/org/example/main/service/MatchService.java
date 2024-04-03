package org.example.main.service;

import org.example.main.dto.ItemDto;
import org.example.main.dto.MatchDto;
import org.example.main.dto.mapper.GameModeDtoMapper;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.dto.mapper.ItemDtoMapper;
import org.example.main.dto.mapper.MatchDtoMapper;
import org.example.main.entity.Item;
import org.example.main.entity.Match;
import org.example.main.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchDto> FindAllMatches() {
        return matchRepository.getMatchList().stream().map(MatchDtoMapper::convertEntityToDto).toList();
    }

    public void deleteMatch(int idInList) {
        matchRepository.getMatchList().remove(idInList);
    }

    public void matchEditUpdate(int idInList, MatchDto matchDto) {
        Match match = matchRepository.getMatchList().get(idInList);
        match.setId(matchDto.getUuid());
        match.setDuration(matchDto.getDuration());
        match.setDireKills(matchDto.getDireKills());
        match.setVictorySide(matchDto.getVictorySide());
        match.setRadiantKills(matchDto.getRadiantKills());
        match.setGameMode(GameModeDtoMapper.convertDtoToEntity(matchDto.getGameMode()));
        matchRepository.getMatchList().set(idInList, match);
    }

    public void addMatch(MatchDto matchDto) {
        matchRepository.getMatchList().add(MatchDtoMapper.convertDtoToEntity(matchDto));
    }
}
