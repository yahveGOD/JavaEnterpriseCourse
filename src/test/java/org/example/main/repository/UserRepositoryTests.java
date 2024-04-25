package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.example.main.entity.Role;
import org.example.main.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUser_whenFindByName_thenOk(){
        User user = User.builder()
                .password("zxc")
                .name("qwe")
                .steamApiKey("qweqwe")
                .averageMatchmakingRating(555)
                .description("qweqwe")
                .build();
        User user1 = User.builder()
                .password("zxc")
                .name("qwerty")
                .averageMatchmakingRating(5551)
                .description("qweqwe")
                .steamApiKey("qweqwe")
                .build();

        userRepository.create(user);
        userRepository.create(user1);

        List<User> testUser = userRepository.findUsersByName(user.getName());

        Assert.assertNotNull(testUser);
        assertEquals(testUser.stream().allMatch(t -> t.getName().equals(user.getName())),true);
    }

}
