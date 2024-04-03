package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    @Getter
    private List<User> userList;
    public UserRepository()
    {
        userList = new ArrayList<>();
        User user1 = new User(0,"zxc","@@@","zxczxczx","123",2500);
        User user2 = new User(1,"mansdn","llkn","zxczxczx","11233",7000);
        userList.add(user1);
        userList.add(user2);
    }
}
