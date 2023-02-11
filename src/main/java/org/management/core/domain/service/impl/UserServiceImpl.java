package org.management.core.domain.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.management.core.application.common.exception.ServerException;
import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.mapper.UserMapper;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    @Resource
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

    @Override
    public User getByUserName(String username) {
        return userMapper.selectOneByExample(makeExampleByUserName(username));
    }

    @Override
    public User userRegister(UserRegisterDTO userRegisterDTO) {
        if (Objects.nonNull(this.getByUserName(userRegisterDTO.getUsername()))){
            throw new ServerException("用户名已存在");
        }
        User user = User.builder()
                .userName(userRegisterDTO.getUsername())
                .userPassword(userRegisterDTO.getPassword())
                .userType(userRegisterDTO.getUsertype())
                .createTime(new Date())
                .build();
        userMapper.insertSelective(user);
        return user;
    }


    private Example makeExampleByUserName(String username){
        Example example = new Example(User.class);
        if (StringUtils.isNotEmpty(username)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("userName",username);
        }
        return example;
    }
}
