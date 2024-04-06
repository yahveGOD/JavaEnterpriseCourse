package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.UserDto;
import org.example.main.mapper.UserDtoMapper;
import org.example.main.entity.User;
import org.example.main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(UserDtoMapper::convertEntityToDto).toList();
    }

    public void deleteUser(int idInList) {
        userRepository.deleteById(idInList);
    }

    public void userEditUpdate(int idInList, UserDto userDto) {
        User user = userRepository.findById(idInList);

        user.setName(userDto.getName());
        user.setDescription(userDto.getDescription());
        user.setPassword(userDto.getPassword());
        user.setSteamApiKey(userDto.getSteamApiKey());
        user.setAverageMatchmakingRating(userDto.getAverageMatchmakingRating());

        userRepository.save(user);
    }

    public void addUser(UserDto userDto) {
        userRepository.save(UserDtoMapper.convertDtoToEntity(userDto));
    }
}
