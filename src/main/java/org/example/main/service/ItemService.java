package org.example.main.service;

import org.example.main.dto.HeroDto;
import org.example.main.dto.ItemDto;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.dto.mapper.ItemDtoMapper;
import org.example.main.entity.Hero;
import org.example.main.entity.Item;
import org.example.main.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<ItemDto> FindAllItems() {
        return itemRepository.getItems().stream().map(ItemDtoMapper::convertEntityToDto).toList();
    }

    public void deleteItem(int idInList) {
        itemRepository.getItems().remove(idInList);
    }

    public void itemEditUpdate(int idInList, ItemDto itemDto) {
        Item item = itemRepository.getItems().get(idInList);
        item.setDescription(itemDto.getDescription());
        item.setId(itemDto.getUuid());
        item.setName(itemDto.getName());
        item.setUseRate(itemDto.getUseRate());
        item.setWinRate(itemDto.getWinRate());
        item.setAbilityDescription(itemDto.getAbilityDescription());
        item.setBoughtTimes(itemDto.getBoughtTimes());
        itemRepository.getItems().set(idInList, item);
    }

    public void addItem(ItemDto itemDto) {
        itemRepository.getItems().add(ItemDtoMapper.convertDtoToEntity(itemDto));
    }
}
