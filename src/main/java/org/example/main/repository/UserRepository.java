package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository extends AbstractRepository<User>{
    public UserRepository()
    {
        save(User.builder()
                .name("zxc")
                .averageMatchmakingRating(11111)
                .description("123")
                .password("@")
                .steamApiKey("zxc")
                .build());
        save(User.builder()
                .name("qqq")
                .averageMatchmakingRating(1222)
                .description("zzz")
                .password("@")
                .steamApiKey("zqqq")
                .build());
    }
}
