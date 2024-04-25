package org.example.main.service;

import lombok.RequiredArgsConstructor;
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

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public void update(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id);

        item.setDescription(itemDto.getDescription());
        item.setName(itemDto.getName());
        item.setUseRate(itemDto.getUseRate());
        item.setWinRate(itemDto.getWinRate());
        item.setAbilityDescription(itemDto.getAbilityDescription());
        item.setBoughtTimes(itemDto.getBoughtTimes());
        item.setInventoryList(itemDto.getInventoryList().stream().map(InventoryDtoMapper::convertDtoToEntity).toList());

        itemRepository.update(item);
    }

    public void addItem(ItemDto itemDto) {
        itemRepository.create(ItemDtoMapper.convertDtoToEntity(itemDto));
    }
}
