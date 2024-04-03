package org.example.main.service;

import org.example.main.dto.StatisticsDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.dto.mapper.StatisticsDtoMapper;
import org.example.main.dto.mapper.TalentTreeDtoMapper;
import org.example.main.entity.Statistics;
import org.example.main.entity.TalentTree;
import org.example.main.repository.TalentTreeRepository;

import java.util.List;

public class TalentTreeService {
    private final TalentTreeRepository talentTreeRepository;

    public TalentTreeService(TalentTreeRepository talentTreeRepository) {
        this.talentTreeRepository = talentTreeRepository;
    }
    public List<TalentTreeDto> FindAllTrees() {
        return talentTreeRepository.getTalentTreeList().stream().map(TalentTreeDtoMapper::convertEntityToDto).toList();
    }

    public void deleteTalentTree(int idInList) {
        talentTreeRepository.getTalentTreeList().remove(idInList);
    }

    public void talentTreeEditUpdate(int idInList,TalentTreeDto talentTreeDto) {
        TalentTree talentTree = talentTreeRepository.getTalentTreeList().get(idInList);
        talentTree.setTalentLeft((talentTreeDto.getTalentLeft()));
        talentTree.setTalentRight(talentTreeDto.getTalentRight());
        talentTree.setId(talentTreeDto.getUuid());
        talentTree.setLevelRequired(talentTreeDto.getLevelRequired());
        talentTree.setHero(HeroDtoMapper.convertDtoToEntity(talentTreeDto.getHero()));
        talentTreeRepository.getTalentTreeList().set(idInList,talentTree);
    }

    public void addTalentTree(TalentTreeDto talentTreeDto) {
        talentTreeRepository.getTalentTreeList().add(TalentTreeDtoMapper.convertDtoToEntity(talentTreeDto));
    }

}
