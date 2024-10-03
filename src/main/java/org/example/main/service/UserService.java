package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.UserCreationDto;
import org.example.main.mapper.*;
import org.example.main.entity.User;
import org.example.main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDtoMapper::convertEntityToDto).toList();
    }

    public UserDto findById(Long id) {
        return UserDtoMapper.convertEntityToDto(userRepository.findById(id));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(Long id, UserDto userDto) {
        User user = userRepository.findById(id);
        if (userDto.getName() != null)
            user.setName(userDto.getName());
        if (userDto.getDescription() != null)
            user.setDescription(userDto.getDescription());
        if (userDto.getPassword() != null)
            user.setPassword(userDto.getPassword());
        if (userDto.getSteamApiKey() != null)
            user.setSteamApiKey(userDto.getSteamApiKey());
        if (userDto.getAverageMatchmakingRating() >= 0)
            user.setAverageMatchmakingRating(userDto.getAverageMatchmakingRating());
        if (userDto.getRoles() != null)
            user.setRoles(userDto.getRoles().stream().map(RoleDtoMapper::convertDtoToEntity).toList());
        if (userDto.getMatches() != null)
            user.setMatches(userDto.getMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
        if (userDto.getPickedHeroes() != null)
            user.setPickedHeroes(userDto.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());

        userRepository.update(user);
    }

    public void addUser(UserDto userDto) {
        userRepository.create(UserDtoMapper.convertDtoToEntity(userDto));
    }

    public void addUser(UserCreationDto userDto) {
        userRepository.create(UserDtoMapper.buildEntity(userDto));
    }
}
