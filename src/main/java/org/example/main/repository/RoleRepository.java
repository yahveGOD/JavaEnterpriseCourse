package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository {
    @Getter
    private List<Role> roleList;
    RoleRepository()
    {
        roleList = new ArrayList<>();
        Role role1 = new Role(0, "zxc");
        Role role2 = new Role(1, "qwe");
        roleList.add(role1);
        roleList.add(role2);
    }
}
