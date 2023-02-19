package org.management.core.domain.service;

import org.management.core.application.common.param.dto.VaccineDTO;
import org.management.core.infrastructure.repository.po.User;

public interface VaccineOrderService {
    
    
    Boolean order(User user, VaccineDTO vaccineDTO);
}
