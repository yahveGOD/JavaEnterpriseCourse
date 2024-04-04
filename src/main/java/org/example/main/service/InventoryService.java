package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.inventory.InventoryDto;
import org.example.main.dto.inventory.InventoryDtoMapper;
import org.example.main.entity.Inventory;
import org.example.main.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<InventoryDto> FindAllInventories() {
        return inventoryRepository.findAll().stream().map(InventoryDtoMapper::convertEntityToDto).toList();
    }

    public void deleteInventory(int idInList) {
        inventoryRepository.deleteById(idInList);
    }

    public void inventoryEditUpdate(int idInList, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.findById(idInList);

        inventory.setBuildEffectivity(inventoryDto.getBuildEffectivity());

        inventoryRepository.save(inventory);
    }

    public void addInventory(InventoryDto inventoryDto) {
        inventoryRepository.save(InventoryDtoMapper.convertDtoToEntity(inventoryDto));
    }
}
