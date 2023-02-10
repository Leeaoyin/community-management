package org.management.core.test.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.management.core.application.common.param.UserEntriesDTO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.utils.TokenUtils;
import org.management.core.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceTest extends BaseTest {
    
    @Autowired
    UserService userService;
    @Autowired
    TokenUtils tokenUtils;
    @Test
    public void testLogin(){
        UserEntriesDTO userEntriesDTO = UserEntriesDTO.builder()
                .username("root")
                .password("123456")
                .build();
        User user = userService.userLogin(userEntriesDTO);
        Assertions.assertNotNull(user);
    }
    
    @Test
    public void testToken(){
        String token  = "eyJhbGciOiJIUzUxMiJ9.eyJ0b2tlbl9jcmVhdGVfdGltZSI6MTY3NjAxOTE3NDQ1Niwic3ViIjoicm9vdCIsInRva2VuX3VzZXJfbmFtZSI6InJvb3QiLCJleHAiOjE2NzYwMjA5NzQsInRva2VuX3VzZXJfcGFzc3dvcmQiOiIxMjM0NTYifQ.Z4rJlSN9BgHmijfn94qkF_zpQuWpgOhfIE2nG9j7z2gW-Ar1OOQKU7EPQGOWj9hfyMBvCZfVw64aTnAYEF9vRQ";
        String username = tokenUtils.getUsername(token);
        System.out.println(username);
    }
}
