package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.UserDto;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.mapper.UserDtoMapper;
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

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void update(Long id, UserDto userDto) {
        User user = userRepository.findById(id);

        user.setName(userDto.getName());
        user.setDescription(userDto.getDescription());
        user.setPassword(userDto.getPassword());
        user.setSteamApiKey(userDto.getSteamApiKey());
        user.setAverageMatchmakingRating(userDto.getAverageMatchmakingRating());
        user.setRoles(userDto.getRoles().stream().map(RoleDtoMapper::convertDtoToEntity).toList());
        user.setMatches(userDto.getMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList());
        user.setPickedHeroes(userDto.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());

        userRepository.update(user);
    }

    public void addUser(UserDto userDto) {
        userRepository.create(UserDtoMapper.convertDtoToEntity(userDto));
    }
}
