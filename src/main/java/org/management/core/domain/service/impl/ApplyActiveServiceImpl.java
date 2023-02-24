package org.management.core.domain.service.impl;

import org.management.core.application.common.param.dto.VerifyDTO;
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
    public Boolean addActives(User user, ApplyActive applyActives) {

        ApplyActive collect = new ApplyActive();
        collect.setUserId(user.getId());
        collect.setCreateTime(new Date());
        collect.setState(0);
        collect.setReason(applyActives.getReason());
        collect.setActiveType(applyActives.getActiveType());
        collect.setFamilyFriend(applyActives.getFamilyFriend());
        collect.setActiveTime(applyActives.getActiveTime());
        return applyActiveMapper.insert(collect) > 0;
    }

    @Override
    public List<ApplyActive> getUnVerifyActive(User user) {
        return null;
    }



    @Override
    public Boolean verifyActive(VerifyDTO verifyDTO) {
        
        Example example = new Example(ApplyActive.class);
        example.createCriteria().andEqualTo("id",verifyDTO.getId());
        ApplyActive applyActive = new ApplyActive();
        applyActive.setState(1);
        return applyActiveMapper.updateByExampleSelective(applyActive,example) > 0;
    }

    @Override
    public List<ApplyActive> getAll(User user) {
        Example example = new Example(ApplyActive.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", user.getId());
        return applyActiveMapper.selectByExample(example);
    }
}
