package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.dto.creationDto.UserCreationDto;
import org.example.main.entity.TalentBranch;
import org.example.main.entity.TalentTree;
import org.example.main.entity.User;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.mapper.UserDtoMapper;
import org.example.main.repository.TalentTreeRepository;
import org.example.main.repository.UserRepository;
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
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        User user = User.builder()
                .id(1L)
                .roles(new ArrayList<>())
                .matches(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .steamApiKey("zxcxzc")
                .name("qwe")
                .password("xczxc")
                .description("qweqwe")
                .averageMatchmakingRating(1231)
                .build();

        User user1 = User.builder()
                .id(2L)
                .roles(new ArrayList<>())
                .matches(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .steamApiKey("111111")
                .name("zcx")
                .password("xqq")
                .description("123")
                .averageMatchmakingRating(111)
                .build();

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user,user1));

        List<UserDto> actualDtos = userService.findAll();

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        User user = User.builder()
                .id(1L)
                .roles(new ArrayList<>())
                .matches(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .steamApiKey("zxcxzc")
                .name("qwe")
                .password("xczxc")
                .description("qweqwe")
                .averageMatchmakingRating(1231)
                .build();

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);

        UserDto expected = UserDtoMapper.convertEntityToDto(user);
        UserDto actual = userService.findById(user.getId());

        Mockito.verify(userRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void saveTest(){
        UserCreationDto userDto = UserCreationDto.builder()
                .steamApiKey("zxcxzc")
                .name("qwe")
                .password("xczxc")
                .description("qweqwe")
                .averageMatchmakingRating(1231)
                .build();
        User user = UserDtoMapper.buildEntity(userDto);

        Mockito.when(userRepository.create(Mockito.any(User.class))).thenReturn(user);

        userService.addUser(userDto);

        Mockito.verify(userRepository, Mockito.times(1)).create(Mockito.any(User.class));
    }

    @Test
    public void updateTest() {
        User user = User.builder()
                .steamApiKey("zxcxzc")
                .name("qwe")
                .password("xczxc")
                .description("qweqwe")
                .averageMatchmakingRating(1231)
                .build();
        UserDto dto = new UserDto();
        dto.setName("1111");

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);

        userService.update(user.getId(), dto);

        Mockito.verify(userRepository, Mockito.times(1)).update(Mockito.any(User.class));
    }
}
