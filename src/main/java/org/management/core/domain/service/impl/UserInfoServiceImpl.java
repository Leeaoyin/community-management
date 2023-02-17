package org.management.core.domain.service.impl;

import org.management.core.application.common.param.dto.ReportDTO;
import org.management.core.domain.service.UserInfoService;
import org.management.core.infrastructure.repository.mapper.UserInfoMapper;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.UserInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    
    @Resource
    UserInfoMapper userInfoMapper;
    
    @Override
    public Boolean reportHealth(User user, ReportDTO reportDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setHealthState(reportDTO.getHealthstate());
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("userId",user.getId());
        return userInfoMapper.updateByExampleSelective(userInfo,example) > 0;
    }
}
