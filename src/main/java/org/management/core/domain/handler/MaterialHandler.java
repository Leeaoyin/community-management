package org.management.core.domain.handler;

import org.management.core.application.common.param.dto.MaterialDTO;
import org.management.core.infrastructure.repository.po.ApplyMaterial;

public class MaterialHandler {
    
    public static ApplyMaterial convertDTO2pojo(MaterialDTO materialDTO){
        ApplyMaterial applyMaterial = new ApplyMaterial();
        applyMaterial.setMaterialName(materialDTO.getMaterialname());
        applyMaterial.setNum(materialDTO.getNum());
        return applyMaterial;
    }
}
