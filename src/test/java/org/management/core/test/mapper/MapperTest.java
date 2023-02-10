package org.management.core.test.mapper;

import org.junit.Test;
import org.management.core.infrastructure.repository.mapper.UserMapper;
import org.management.core.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class MapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUser(){
        System.out.println(userMapper.selectAll());
    }
}
