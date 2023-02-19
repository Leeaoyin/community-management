package org.management.core.domain.service.impl;

import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.domain.service.VaccineOrderService;
import org.management.core.infrastructure.repository.mapper.VaccineOrderMapper;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.VaccineOrder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class VaccineOrderServiceImpl implements VaccineOrderService {
    
    @Resource
    VaccineOrderMapper vaccineOrderMapper;


    @Override
    public Boolean order(User user, VaccineDTO vaccineDTO) {
        VaccineOrder vaccineOrder = new VaccineOrder();
        vaccineOrder.setUserId(user.getId());
        vaccineOrder.setPhone(vaccineDTO.getPhone());
        vaccineOrder.setVaccineName(vaccineDTO.getVaccinename());
        vaccineOrder.setOrderTime(vaccineDTO.getOrdertime());
        vaccineOrder.setCreateTime(new Date());
        vaccineOrder.setState(vaccineDTO.getOrdertime().before(new Date()) ? 0 : 1);
        return vaccineOrderMapper.insertSelective(vaccineOrder) > 0;
    }
}
