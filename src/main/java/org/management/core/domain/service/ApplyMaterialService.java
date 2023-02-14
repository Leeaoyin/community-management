package org.management.core.domain.service;

import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.ApplyMaterial;
import org.management.core.infrastructure.repository.po.User;

import java.util.List;

public interface ApplyMaterialService {


    /**
     * add materials
     * @param user
     * @param applyMaterials
     * @return
     */
    Boolean addMaterials(User user, List<ApplyMaterial> applyMaterials);

    /**
     * get unchecked materials of this user
     * @param user
     * @return
     */
    List<ApplyActive> getUnVerifyMaterials(User user);

    /**
     * verify materials's state 
     * @param applyMaterials
     * @return
     */
    List<ApplyActive> verifyMaterials(List<ApplyMaterial> applyMaterials);
    
    
    List<ApplyMaterial> getAll(User user);
}
