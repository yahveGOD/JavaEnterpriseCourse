package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.MatchDto;
import org.example.main.dto.creationDto.ReplayCreationDto;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.dto.ReplayDto;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.entity.Replay;
import org.example.main.repository.ReplayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplayService {
    private final ReplayRepository replayRepository;

    public List<ReplayDto> findAll() {
        return replayRepository.findAll().stream().map(ReplayDtoMapper::convertEntityToDto).toList();
    }

    public ReplayDto findById(Long id) {
        return ReplayDtoMapper.convertEntityToDto(replayRepository.findById(id));
    }

    public void delete(Long id) {
        replayRepository.deleteById(id);
    }

    public void update(Long id, ReplayDto replayDto) {
        Replay replay = replayRepository.findById(id);
        if (replayDto.getSteamApiMatchReplayKey()!= null)
            replay.setSteamApiMatchReplayKey(replayDto.getSteamApiMatchReplayKey());
        if (replayDto.getMatch() != null)
            replay.setMatch(MatchDtoMapper.convertDtoToEntity(replayDto.getMatch()));

        replayRepository.update(replay);
    }

    public void addReplay(ReplayDto replayDto) {
        replayRepository.create(ReplayDtoMapper.convertDtoToEntity(replayDto));
    }

    public void addReplay(ReplayCreationDto replayDto) {
        replayRepository.create(ReplayDtoMapper.buildEntity(replayDto));
    }


    public void addMatch(Long id, MatchDto matchDto) {
        Replay replay = replayRepository.findById(id);
        replay.setMatch(MatchDtoMapper.convertDtoToEntity(matchDto));
        replayRepository.create(replay);
    }
}
