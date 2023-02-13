package org.management.core.domain.service.impl;

import org.management.core.domain.service.ApplyActiveService;
import org.management.core.infrastructure.repository.mapper.ApplyActiveMapper;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyActiveServiceImpl implements ApplyActiveService {
    
    
    @Resource
    ApplyActiveMapper applyActiveMapper;
    
    @Override
    public Boolean addActives(User user, List<ApplyActive> applyActives) {
        List<ApplyActive> collect = applyActives.stream()
                .peek(e -> {
                    e.setUserId(user.getId());
                    e.setCreateTime(new Date());
                    e.setState(0);
                })
                .collect(Collectors.toList());
        return applyActiveMapper.insertList(collect) > 0 ? true : false;
    }

    @Override
    public List<ApplyActive> getUnVerifyActive(User user) {
        return null;
    }

    @Override
    public List<ApplyActive> verifyActive(List<ApplyActive> applyActives) {
        return null;
    }

    @Override
    public List<ApplyActive> getAll(User user) {
        Example example = new Example(ApplyActive.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", user.getId());
        return applyActiveMapper.selectByExample(example);
    }
}
