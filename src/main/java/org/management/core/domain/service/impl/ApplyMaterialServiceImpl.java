package org.management.core.domain.service.impl;

import org.management.core.domain.service.ApplyMaterialService;
import org.management.core.infrastructure.repository.mapper.ApplyMaterialMapper;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.ApplyMaterial;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyMaterialServiceImpl implements ApplyMaterialService {
    
    
    @Resource
    ApplyMaterialMapper applyMaterialMapper;
    @Override
    public Boolean addMaterials(User user, List<ApplyMaterial> applyMaterials) {
        List<ApplyMaterial> collect = applyMaterials.stream()
                .peek(e -> {
                    e.setUserId(user.getId());
                    e.setCreateTime(new Date());
                })
                .collect(Collectors.toList());
        return applyMaterialMapper.insertList(collect) > 0 ? true : false;
    }

    @Override
    public List<ApplyActive> getUnVerifyMaterials(User user) {
        return null;
    }

    @Override
    public List<ApplyActive> verifyMaterials(List<ApplyMaterial> applyMaterials) {
        return null;
    }

    @Override
    public List<ApplyMaterial> getAll(User user) {
        Example example = new Example(ApplyMaterial.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",user.getId());
        return applyMaterialMapper.selectByExample(example);
    }
}
