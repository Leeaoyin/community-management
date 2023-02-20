package org.management.core.domain.service.impl;

import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.application.common.param.vo.OrderedVaccineVO;
import org.management.core.domain.service.VaccineOrderService;
import org.management.core.infrastructure.repository.mapper.VaccineOrderMapper;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.VaccineOrder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        vaccineOrder.setState(vaccineDTO.getOrdertime().before(new Date()) ? 1 : 0);
        return vaccineOrderMapper.insertSelective(vaccineOrder) > 0;
    }

    @Override
    public List<OrderedVaccineVO> getAll(User user) {
        Example example = new Example(VaccineOrder.class);
        example.createCriteria().andEqualTo("userId",user.getId());
        List<VaccineOrder> vaccineOrders = vaccineOrderMapper.selectByExample(example);
        List<OrderedVaccineVO> vo = new ArrayList<>(vaccineOrders.size());
        vaccineOrders.forEach(e-> vo.add(
                OrderedVaccineVO
                .builder()
                .vaccinename(e.getVaccineName())
                .phone(e.getPhone())
                .state(e.getState())
                .ordertime(e.getOrderTime()).build()));
                
        return vo;
    }
}
