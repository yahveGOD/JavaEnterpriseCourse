package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.HeroDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.entity.TalentTree;
import org.example.main.repository.TalentTreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TalentTreeService {
    private final TalentTreeRepository talentTreeRepository;

    public List<TalentTreeDto> findAllTrees() {
        return talentTreeRepository.findAll().stream().map(TalentTreeDtoMapper::convertEntityToDto).toList();
    }

    public void deleteTalentTree(int idInList) {
        talentTreeRepository.deleteById(idInList);
    }

    public void talentTreeEditUpdate(int idInList,TalentTreeDto talentTreeDto) {
        TalentTree talentTree = talentTreeRepository.findById(idInList);

        talentTree.setTalentLeft((talentTreeDto.getTalentLeft()));
        talentTree.setTalentRight(talentTreeDto.getTalentRight());
        talentTree.setLevelRequired(talentTreeDto.getLevelRequired());

        talentTreeRepository.save(talentTree);
    }

    public void addTalentTree(TalentTreeDto talentTreeDto) {
        talentTreeRepository.save(TalentTreeDtoMapper.convertDtoToEntity(talentTreeDto));
    }

    public void addHero(long id, HeroDto heroDto)
    {
        TalentTree talentTree = talentTreeRepository.findById(id);
        talentTree.setHero(HeroDtoMapper.convertDtoToEntity(heroDto));
        talentTreeRepository.save(talentTree);
    }
}
