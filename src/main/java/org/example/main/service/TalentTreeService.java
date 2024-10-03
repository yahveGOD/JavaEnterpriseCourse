package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.HeroDto;
import org.example.main.dto.ItemDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.entity.TalentTree;
import org.example.main.repository.TalentTreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TalentTreeService {
    private final TalentTreeRepository talentTreeRepository;

    public List<TalentTreeDto> findAll() {
        return talentTreeRepository.findAll().stream().map(TalentTreeDtoMapper::convertEntityToDto).toList();
    }

    public TalentTreeDto findById(Long id) {
        return TalentTreeDtoMapper.convertEntityToDto(talentTreeRepository.findById(id));
    }

    public void delete(Long id) {
        talentTreeRepository.deleteById(id);
    }

    public void update(Long id, TalentTreeDto talentTreeDto) {
        TalentTree talentTree = talentTreeRepository.findById(id);
//        if (talentTreeDto.getTalentBranch() != null)
//            talentTree.setTalentBranch(talentTreeDto.getTalentBranch());
        if (talentTreeDto.getLevelRequired() != null)
            talentTree.setLevelRequired(talentTreeDto.getLevelRequired());

        talentTreeRepository.update(talentTree);
    }

    public void addTalentTree(TalentTreeDto talentTreeDto) {
        talentTreeRepository.create(TalentTreeDtoMapper.convertDtoToEntity(talentTreeDto));
    }

    public void addHero(Long id, HeroDto heroDto) {
        TalentTree talentTree = talentTreeRepository.findById(id);
        talentTree.setHero(HeroDtoMapper.convertDtoToEntity(heroDto));
        talentTreeRepository.create(talentTree);
    }

    public void addTalentTree(TalentTreeCreationDto talentTreeDto) {
        talentTreeRepository.create(TalentTreeDtoMapper.buildEntity(talentTreeDto));
    }
}
