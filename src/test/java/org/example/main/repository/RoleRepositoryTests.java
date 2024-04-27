package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
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

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
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

        Assert.assertNotNull(testRole);
        assertEquals(testRole.stream().allMatch(t -> t.getTitle().equals(role.getTitle())),true);
    }
}
