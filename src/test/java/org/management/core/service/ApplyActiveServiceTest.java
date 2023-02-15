package org.management.core.service;

import org.junit.Test;
import org.management.core.domain.service.ApplyActiveService;
import org.management.core.infrastructure.repository.po.ApplyActive;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyActiveServiceTest extends BaseTest {
    
    @Autowired
    ApplyActiveService applyActiveService;
    @Test
    public void addList(){
        User user = new User(1,"root","123456",1,null,null);
        List<ApplyActive> applyActives = new ArrayList<>();
        ApplyActive applyActive = new ApplyActive();
        
        applyActive.setActiveType(1);
        applyActive.setActiveTime(new Date());
        applyActive.setReason("出去买麻辣烫");
//        applyActive.setFamilyFriend("['大舅','二舅','四婶','小姨子']");
        
        applyActives.add(applyActive);
        Boolean aBoolean = applyActiveService.addActives(user, applyActives);
        System.out.println(aBoolean);
    }
}
