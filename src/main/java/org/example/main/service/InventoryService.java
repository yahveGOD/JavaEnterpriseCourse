package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.creationDto.InventoryCreationDto;
import org.example.main.dto.InventoryDto;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.entity.Inventory;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryDto> findAll() {
        return inventoryRepository.findAll().stream().map(InventoryDtoMapper::convertEntityToDto).toList();
    }

    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }

    public void update(Long id, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findById(id);
        if (inventoryDto.getBuildEffectivity() >= 0)
            inventory.setBuildEffectivity(inventoryDto.getBuildEffectivity());
        if (inventoryDto.getItems() != null)
            inventory.setItems(inventoryDto.getItems().stream().map(ItemDtoMapper::convertDtoToEntity).toList());
        if (inventoryDto.getPickedHeroes() != null)
            inventory.setPickedHeroes(inventoryDto.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());

        inventoryRepository.update(inventory);
    }

    public void addInventory(InventoryDto inventoryDto) {
        inventoryRepository.create(InventoryDtoMapper.convertDtoToEntity(inventoryDto));
    }

    public void addInventory(InventoryCreationDto inventoryDto) {
        inventoryRepository.create(InventoryDtoMapper.buildEntity(inventoryDto));
    }

    public InventoryDto findById(Long id) {
        return InventoryDtoMapper.convertEntityToDto(inventoryRepository.findById(id));
    }
}
