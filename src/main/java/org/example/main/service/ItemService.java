package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.item.ItemDto;
import org.example.main.dto.item.ItemDtoMapper;
import org.example.main.entity.Item;
import org.example.main.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemDto> FindAllItems() {
        return itemRepository.findAll().stream().map(ItemDtoMapper::convertEntityToDto).toList();
    }

    public void deleteItem(int idInList) {
        itemRepository.deleteById(idInList);
    }

    public void itemEditUpdate(int idInList, ItemDto itemDto) {
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
