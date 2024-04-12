package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.RoleDto;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.entity.Role;
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

    public void delete(int idInList) {
        roleRepository.deleteById(idInList);
    }

    public void update(int idInList, RoleDto roleDto) {
        Role role = roleRepository.findById(idInList);

        role.setTitle(roleDto.getTitle());

        roleRepository.save(role);
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.save(RoleDtoMapper.convertDtoToEntity(roleDto));
    }
}
