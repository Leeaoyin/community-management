package org.management.core.mapper;

import org.junit.Test;
import org.management.core.BaseTest;
import org.management.core.infrastructure.repository.mapper.UserMapper;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUser(){
        List<User> users = userMapper.selectAll();
        users.forEach(e-> System.out.println(e.getUserName()));
    }
}
