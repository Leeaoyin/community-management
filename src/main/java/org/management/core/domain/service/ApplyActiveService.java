package org.management.core.domain.service;

import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.User;

import java.util.List;

public interface ApplyActiveService {
    

    /**
     * add the user's application of active
     * @param user
     * @param applyActives
     * @return
     */
    Boolean addActives(User user, List<ApplyActive> applyActives);

    /**
     * get unchecked active of this user
     * @param user
     * @return
     */
    List<ApplyActive> getUnVerifyActive(User user);

    /**
     * verify active's state 
     * @param applyActives
     * @return
     */
    Boolean verifyActive(List<Integer> applyActives);
    
    List<ApplyActive> getAll(User user);
}
