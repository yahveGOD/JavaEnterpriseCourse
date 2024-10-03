package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.RoleDto;
import org.example.main.dto.creationDto.ReplayCreationDto;
import org.example.main.dto.creationDto.RoleCreationDto;
import org.example.main.entity.Replay;
import org.example.main.entity.Role;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.repository.ReplayRepository;
import org.example.main.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { LiquibaseConfig.class, HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class RoleServiceTest {
    @InjectMocks
    private RoleService roleService;
    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Role role = Role.builder()
                .id(1L)
                .title("zxc")
                .users(new ArrayList<>())
                .build();
        Role role1 = Role.builder()
                .id(2L)
                .title("qwe")
                .users(new ArrayList<>())
                .build();
        Mockito.when(roleRepository.findAll()).thenReturn(List.of(role,role1));

        List<RoleDto> actualDtos = roleService.findAll();

        Mockito.verify(roleRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Role role = Role.builder()
                .id(1L)
                .title("zxc")
                .users(new ArrayList<>())
                .build();

        Mockito.when(roleRepository.findById(role.getId())).thenReturn(role);

        RoleDto expected = RoleDtoMapper.convertEntityToDto(role);
        RoleDto actual = roleService.findById(role.getId());

        Mockito.verify(roleRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    public void saveTest(){
        RoleCreationDto roleDto = RoleCreationDto.builder()
                .title("zxc")
                .build();

        Role role = RoleDtoMapper.buildEntity(roleDto);

        Mockito.when(roleRepository.create(Mockito.any(Role.class))).thenReturn(role);

        roleService.addRole(roleDto);

        Mockito.verify(roleRepository, Mockito.times(1)).create(Mockito.any(Role.class));
    }

    @Test
    public void updateTest() {
        Role role = Role.builder()
                .title("zxc")
                .build();
        RoleDto dto = new RoleDto();
        dto.setTitle("1000L");

        Mockito.when(roleRepository.findById(role.getId())).thenReturn(role);

        roleService.update(role.getId(), dto);

        Mockito.verify(roleRepository, Mockito.times(1)).update(Mockito.any(Role.class));
    }
}
