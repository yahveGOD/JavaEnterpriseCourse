package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.match.MatchDto;
import org.example.main.dto.match.MatchDtoMapper;
import org.example.main.dto.replay.ReplayDto;
import org.example.main.dto.replay.ReplayDtoMapper;
import org.example.main.entity.Replay;
import org.example.main.repository.ReplayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplayService {
    private final ReplayRepository replayRepository;
    public List<ReplayDto> FindAllReplays() {
        return replayRepository.findAll().stream().map(ReplayDtoMapper::convertEntityToDto).toList();
    }

    public void deleteReplay(int idInList) {
        replayRepository.deleteById(idInList);
    }

    public void replayEditUpdate(int idInList, ReplayDto replayDto) {
        Replay replay = replayRepository.findById(idInList);

        replay.setSteamApiMatchReplayKey(replayDto.getSteamApiMatchReplayKey());

        replayRepository.save(replay);
    }

    public void addReplay(ReplayDto replayDto) {
        replayRepository.save(ReplayDtoMapper.convertDtoToEntity(replayDto));
    }

    public void addMatch(long id, MatchDto matchDto)
    {
        Replay replay = replayRepository.findById(id);
        replay.setMatch(MatchDtoMapper.convertDtoToEntity(matchDto));
        replayRepository.save(replay);
    }
}
