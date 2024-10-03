package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.dto.ItemDto;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.entity.Item;
import org.example.main.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream().map(ItemDtoMapper::convertEntityToDto).toList();
    }

    public ItemDto findById(Long id) {
        return ItemDtoMapper.convertEntityToDto(itemRepository.findById(id));
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public void update(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id);
        if (itemDto.getDescription() != null)
            item.setDescription(itemDto.getDescription());
        if (itemDto.getName() != null)
            item.setName(itemDto.getName());
        if (itemDto.getUseRate() >= 0)
            item.setUseRate(itemDto.getUseRate());
        if (itemDto.getWinRate() >= 0)
            item.setWinRate(itemDto.getWinRate());
        if (itemDto.getAbilityDescription() != null)
            item.setAbilityDescription(itemDto.getAbilityDescription());
        if (itemDto.getBoughtTimes() >= 0)
            item.setBoughtTimes(itemDto.getBoughtTimes());
        if (itemDto.getInventoryList() != null)
            item.setInventoryList(itemDto.getInventoryList().stream().map(InventoryDtoMapper::convertDtoToEntity).toList());

        itemRepository.update(item);
    }

    public void addItem(ItemDto itemDto) {
        itemRepository.create(ItemDtoMapper.convertDtoToEntity(itemDto));
    }

    public void addItem(ItemCreationDto itemDto) {
        itemRepository.create(ItemDtoMapper.buildEntity(itemDto));
    }

}
