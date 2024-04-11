package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
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

    public void delete(int idInList) {
        itemRepository.deleteById(idInList);
    }

    public void update(int idInList, ItemDto itemDto) {
        Item item = itemRepository.findById(idInList);

        item.setDescription(itemDto.getDescription());
        item.setName(itemDto.getName());
        item.setUseRate(itemDto.getUseRate());
        item.setWinRate(itemDto.getWinRate());
        item.setAbilityDescription(itemDto.getAbilityDescription());
        item.setBoughtTimes(itemDto.getBoughtTimes());

        itemRepository.save(item);
    }

    public void addItem(ItemDto itemDto) {
        itemRepository.save(ItemDtoMapper.convertDtoToEntity(itemDto));
    }
}
