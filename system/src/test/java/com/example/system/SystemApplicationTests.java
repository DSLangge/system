package com.example.system;

import com.example.system.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemApplicationTests {

    @Resource
    private User user;

    @Test
    public void contextLoads() {
        user.setId(1);
        user.setPassword("123");
        System.out.println(user);

    }

}
