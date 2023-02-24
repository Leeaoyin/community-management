package org.management.core.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.utils.TokenUtils;
import org.management.core.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UserServiceTest extends BaseTest {
    
    @Autowired
    UserService userService;
    @Autowired
    TokenUtils tokenUtils;
    @Test
    public void testLogin(){
        
        Collections.synchronizedMap(new HashMap<>(10));

        List<User> synchronizedList = Collections.synchronizedList(new ArrayList<User>(10));
        UserEntriesDTO userEntriesDTO = UserEntriesDTO.builder()
                .username("root")
                .password("123456")
                .build();
        User user = userService.userLogin(userEntriesDTO);
        Assertions.assertNotNull(user);
    }
    
    @Test
    public void testToken(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJ0b2tlbl9jcmVhdGVfdGltZSI6MTY3NjA4NDc2OTM0MCwic3ViIjoiYWRtaW4iLCJ0b2tlbl91c2VyX25hbWUiOiJhZG1pbiIsInRva2VuX3VzZXJfcGFzc3dvcmQiOiIxMjM0NTYifQ.a6zvch3hVtEXFpH2pnQrkpb_044RRiUebjR5uKEAKqAxAREv95X_nypYMKV1SrsBuRtb4dozMFpjSnjLLcKQxw";
        Date expirationDate = tokenUtils.getExpirationDate(token);
        System.out.println(Objects.equals(null,expirationDate));

    }
}
