package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.RoleDto;
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

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public void update(Long id, RoleDto roleDto) {
        Role role = roleRepository.findById(id);

        role.setTitle(roleDto.getTitle());
        role.setUsers(roleDto.getUsers().stream().map(UserDtoMapper::convertDtoToEntity).toList());

        roleRepository.update(role);
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.create(RoleDtoMapper.convertDtoToEntity(roleDto));
    }
}
