package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.creationDto.RoleCreationDto;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.entity.Role;
import org.example.main.mapper.UserDtoMapper;
import org.example.main.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream().map(RoleDtoMapper::convertEntityToDto).toList();
    }

    public RoleDto findById(Long id) {
        return RoleDtoMapper.convertEntityToDto(roleRepository.findById(id));
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public void update(Long id, RoleDto roleDto) {
        Role role = roleRepository.findById(id);
        if (roleDto.getTitle() != null)
            role.setTitle(roleDto.getTitle());
        if (roleDto.getUsers() != null)
            role.setUsers(roleDto.getUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());

        roleRepository.update(role);
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.create(RoleDtoMapper.convertDtoToEntity(roleDto));
    }

    public void addRole(RoleCreationDto roleDto) {
        roleRepository.create(RoleDtoMapper.buildEntity(roleDto));
    }

}
