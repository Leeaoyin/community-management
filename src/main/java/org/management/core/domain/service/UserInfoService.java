package org.management.core.domain.service;

import org.management.core.application.common.param.dto.ReportDTO;
import org.management.core.infrastructure.repository.po.User;

public interface UserInfoService {

    /**
     * report health state of user
     * @param user
     * @param reportDTO
     * @return
     */
    Boolean reportHealth(User user, ReportDTO reportDTO);
}
