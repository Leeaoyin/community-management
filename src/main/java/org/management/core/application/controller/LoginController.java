package org.management.core.application.controller;


import org.management.core.application.common.Const;
import org.management.core.application.common.enums.HttpCodeEnum;
import org.management.core.application.common.param.UserEntriesDTO;
import org.management.core.application.common.param.result.ResponseResult;
import org.management.core.application.common.param.vo.UserVO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    
    
    @Autowired
    private UserService userService;
    
    @PostMapping(Const.API_URL+"/login")
    public ResponseResult<UserVO> login(@RequestBody @Valid UserEntriesDTO userEntriesDTO){
        User user = userService.userLogin(userEntriesDTO);
        UserVO userVO = UserVO.builder()
                .userId(user.getId())
                .userType(user.getUserType())
                .token("eyJhbGciOiJIUzUxMiJ9")
                .build();
        return ResponseResult.success(userVO);

    }
}
