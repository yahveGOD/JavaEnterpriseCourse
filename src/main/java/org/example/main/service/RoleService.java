package org.example.main.service;

import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.mapper.*;
import org.example.main.entity.PickedHero;
import org.example.main.entity.Role;
import org.example.main.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> FindAllRoles() {
        return roleRepository.getRoleList().stream().map(RoleDtoMapper::convertEntityToDto).toList();
    }

    public void deleteRole(int idInList) {
        roleRepository.getRoleList().remove(idInList);
    }

    public void roleEditUpdate(int idInList, RoleDto roleDto) {
        Role role = roleRepository.getRoleList().get(idInList);
        role.setId(roleDto.getUuid());
        role.setTitle(roleDto.getTitle());
        roleRepository.getRoleList().set(idInList, role);
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.getRoleList().add(RoleDtoMapper.convertDtoToEntity(roleDto));
    }
}
