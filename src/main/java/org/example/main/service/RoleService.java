package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.role.RoleDto;
import org.example.main.dto.role.RoleDtoMapper;
import org.example.main.entity.Role;
import org.example.main.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleDto> FindAllRoles() {
        return roleRepository.findAll().stream().map(RoleDtoMapper::convertEntityToDto).toList();
    }

    public void deleteRole(int idInList) {
        roleRepository.deleteById(idInList);
    }

    public void roleEditUpdate(int idInList, RoleDto roleDto) {
        Role role = roleRepository.findById(idInList);

        role.setTitle(roleDto.getTitle());

        roleRepository.save(role);
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.save(RoleDtoMapper.convertDtoToEntity(roleDto));
    }
}
