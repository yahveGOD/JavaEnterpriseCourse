package org.example.main.service;

import org.example.main.dto.MatchDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.mapper.*;
import org.example.main.entity.PickedHero;
import org.example.main.entity.Replay;
import org.example.main.repository.ReplayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReplayService {
    private final ReplayRepository replayRepository;

    public ReplayService(ReplayRepository replayRepository) {
        this.replayRepository = replayRepository;
    }

    public List<ReplayDto> FindAllReplays() {
        return replayRepository.getReplayList().stream().map(ReplayDtoMapper::convertEntityToDto).toList();
    }

    public void deleteReplay(int idInList) {
        replayRepository.getReplayList().remove(idInList);
    }

    public void replayEditUpdate(int idInList, ReplayDto replayDto) {
        Replay replay = replayRepository.getReplayList().get(idInList);
        replay.setId(replayDto.getUuid());
        replay.setSteamApiMatchReplayKey(replayDto.getSteamApiMatchReplayKey());
        replay.setMatch(MatchDtoMapper.convertDtoToEntity(replayDto.getMatch()));
        replayRepository.getReplayList().set(idInList, replay);
    }

    public void addReplay(ReplayDto replayDto) {
        replayRepository.getReplayList().add(ReplayDtoMapper.convertDtoToEntity(replayDto));
    }
}
