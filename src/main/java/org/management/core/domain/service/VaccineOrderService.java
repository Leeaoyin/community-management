package org.management.core.domain.service;

import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.repository.po.VaccineOrder;

import java.util.List;

public interface VaccineOrderService {

    /**
     * 预约
     * @param user
     * @param vaccineDTO
     * @return
     */
    Boolean order(User user, VaccineDTO vaccineDTO);

    /**
     * 获取当前用户预约列表
     * @param user
     * @return
     */
    List<VaccineOrder> getAll(User user);
}
