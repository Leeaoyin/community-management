package org.management.core.domain.service.impl;

import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.domain.service.VaccineOrderService;
import org.management.core.infrastructure.repository.mapper.VaccineOrderMapper;
import org.management.core.infrastructure.repository.po.User;

import javax.annotation.Resource;

public class VaccineOrderServiceImpl implements VaccineOrderService {
    
    @Resource
    VaccineOrderMapper vaccineOrderMapper;


    @Override
    public Boolean order(User user, VaccineDTO vaccineDTO) {
        return null;
    }
}
