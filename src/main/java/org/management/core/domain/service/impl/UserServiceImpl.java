package org.management.core.domain.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.management.core.application.common.param.UserEntriesDTO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.mapper.UserMapper;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;
    @Override
    public User userLogin(UserEntriesDTO userEntriesDTO) {
        String username = userEntriesDTO.getUsername();
        Example example = makeExampleByUserName(username);
        User user = userMapper.selectOneByExample(example);
        if (Objects.nonNull(user)){
            boolean checked = StringUtils.equals(user.getUserPassword(),userEntriesDTO.getPassword()) ? true : false;
            if (checked) return user;
        }
        return user;
    }


    private Example makeExampleByUserName(String username){
        if (StringUtils.isNotEmpty(username)){
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userName",username);
            return example;
        }
        return null;
    }
}
