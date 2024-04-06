package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleRepository extends AbstractRepository<Role> {
    RoleRepository()
    {
        save(Role.builder()
                .title("123")
                .build());
    }
}
