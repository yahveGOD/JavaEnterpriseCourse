package org.example.main.service;

import org.example.main.dto.StatisticsDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.mapper.HeroDtoMapper;
import org.example.main.dto.mapper.StatisticsDtoMapper;
import org.example.main.dto.mapper.TalentTreeDtoMapper;
import org.example.main.dto.mapper.UserDtoMapper;
import org.example.main.entity.TalentTree;
import org.example.main.entity.User;
import org.example.main.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> FindAllUsers() {
        return userRepository.getUserList().stream().map(UserDtoMapper::convertEntityToDto).toList();
    }

    public void deleteUser(int idInList) {
        userRepository.getUserList().remove(idInList);
    }

    public void userEditUpdate(int idInList, UserDto userDto) {
        User user = userRepository.getUserList().get(idInList);
        user.setId(userDto.getUuid());
        user.setName(userDto.getName());
        user.setDescription(userDto.getDescription());
        user.setPassword(userDto.getPassword());
        user.setSteamApiKey(userDto.getSteamApiKey());
        user.setAverageMatchmakingRating(userDto.getAverageMatchmakingRating());
        userRepository.getUserList().set(idInList, user);
    }

    public void addUser(UserDto userDto) {
        userRepository.getUserList().add(UserDtoMapper.convertDtoToEntity(userDto));
    }
}
