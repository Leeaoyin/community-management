package org.management.core.domain.handler;

import org.management.core.application.common.param.dto.ActiveDTO;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.utils.JsonUtils;

public class ActiveHandler {
    
    public static ApplyActive convertDTO2pojo(ActiveDTO activeDTO){
        ApplyActive applyActive = new ApplyActive();
        applyActive.setActiveType(activeDTO.getActivetype());
        applyActive.setActiveTime(activeDTO.getActivetime());
        applyActive.setReason(activeDTO.getReason());
        applyActive.setFamilyFriend(JsonUtils.parse(activeDTO.getFamilyfriend()));
        return applyActive;
    }
    
}
