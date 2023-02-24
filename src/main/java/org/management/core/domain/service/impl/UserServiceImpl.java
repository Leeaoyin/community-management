package org.management.core.domain.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.management.core.application.common.exception.ServerException;
import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserInfoDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.application.common.param.vo.UserListVO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.mapper.UserInfoMapper;
import org.management.core.infrastructure.repository.mapper.UserMapper;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.UserInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserMapper userMapper;
    
    @Resource
    UserInfoMapper userInfoMapper;
    
    @Override
    public User userLogin(UserEntriesDTO userEntriesDTO) {
        String username = userEntriesDTO.getUsername();
        Example example = makeExampleByUserName(username);
        User user = userMapper.selectOneByExample(example);
        if (Objects.nonNull(user)){
            boolean checked = StringUtils.equals(user.getUserPassword(), userEntriesDTO.getPassword());
            if (checked) 
                return user;
            else   
                throw new ServerException("密码错误");
        }else {
            throw new ServerException("用户名不存在");
        }
    }

    @Override
    public User getByUserName(String username) {
        return userMapper.selectOneByExample(makeExampleByUserName(username));
    }

    @Override
    public Boolean userRegister(UserRegisterDTO userRegisterDTO) {
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
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userName",user.getUserName());
        if (Objects.nonNull(userInfoMapper.selectOneByExample(example))){
            throw new ServerException("信息已存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(user.getUserName());
        userInfo.setCreateTime(new Date());
        Example userExample = new Example(User.class);
        userExample.createCriteria().andEqualTo("userName",user.getUserName());
        userInfo.setUserId(userMapper.selectOneByExample(userExample).getId());
        userInfo.setHealthState(userRegisterDTO.getHealthstate());
        userInfo.setRoomNumber(userRegisterDTO.getRoomnumber());
        userInfo.setEmail(userRegisterDTO.getEmail());
        userInfo.setPhone(userRegisterDTO.getPhone());
        return userInfoMapper.insert(userInfo) > 0 ;
    }

    @Override
    public Boolean addUserInfo(User user, UserInfoDTO userInfoDTO) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userName",user.getUserName());
        if (Objects.nonNull(userInfoMapper.selectOneByExample(example))){
            throw new ServerException("信息已存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(user.getUserName());
        userInfo.setCreateTime(new Date());
        userInfo.setUserId(user.getId());
        userInfo.setHealthState(userInfoDTO.getHealthstate());
        userInfo.setRoomNumber(userInfoDTO.getRoomnumber());
        userInfo.setEmail(userInfoDTO.getEmail());
        userInfo.setPhone(userInfoDTO.getPhone());
        return userInfoMapper.insert(userInfo) > 0;
    }

    @Override
    public List<UserListVO> getUserList(User user) {
        List<User> userList = userMapper.selectAll();
        List<UserListVO> userListVOList = new ArrayList<UserListVO>(userList.size());
                userList.stream().forEach(
                e->{
                    Example example  = new Example(UserInfo.class);
                    example.createCriteria().andEqualTo("userId",e.getId());
                    UserInfo userInfo = userInfoMapper.selectOneByExample(example);
                    if (Objects.nonNull(userInfo)){
                        userListVOList.add(UserListVO.builder()
                                .email(userInfo.getEmail())
                                .username(e.getUserName())
                                .phone(userInfo.getPhone())
                                .roomnumber(userInfo.getRoomNumber())
                                .healthstate(userInfo.getHealthState())
                                .build());
                    }
                }
        );
        
        return userListVOList;
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
