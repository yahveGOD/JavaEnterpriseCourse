package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Role;
import org.example.main.entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void givenRole_whenFindByTitle_thenOk(){
        Role role = Role.builder()
                .title("qwe")
                .build();

        Role role1 = Role.builder()
                .title("qwezxc")
                .build();

        roleRepository.create(role1);
        roleRepository.create(role);

        List<Role> testRole = roleRepository.findRolesByTitle(role.getTitle());

        Assertions.assertNotNull(testRole);
        Assertions.assertEquals(testRole.stream().allMatch(t -> t.getTitle().equals(role.getTitle())),true);
    }
}
