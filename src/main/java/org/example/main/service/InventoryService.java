package org.example.main.service;

import org.example.main.dto.HeroDto;
import org.example.main.dto.InventoryDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.dto.mapper.InventoryDtoMapper;
import org.example.main.dto.mapper.RoleDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.entity.Inventory;
import org.example.main.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryDto> FindAllInventories() {
        return inventoryRepository.getInventories().stream().map(InventoryDtoMapper::convertEntityToDto).toList();
    }

    public void deleteInventory(int idInList) {
        inventoryRepository.getInventories().remove(idInList);
    }

    public void inventoryEditUpdate(int idInList, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepository.getInventories().get(idInList);
        inventory.setId(inventoryDto.getUuid());
        inventory.setBuildEffectivity(inventoryDto.getBuildEffectivity());
        inventoryRepository.getInventories().set(idInList, inventory);
    }

    public void addInventory(InventoryDto inventoryDto) {
        inventoryRepository.getInventories().add(InventoryDtoMapper.convertDtoToEntity(inventoryDto));
    }
}
