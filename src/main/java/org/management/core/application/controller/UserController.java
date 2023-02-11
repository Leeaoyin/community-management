package org.management.core.application.controller;


import org.management.core.domain.event.Const;
import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.application.common.param.result.ResponseResult;
import org.management.core.application.common.param.vo.UserVO;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController extends BaseController{
    
    
    @Autowired
    private UserService userService;
    
    @PostMapping(Const.API_URL+"/login")
    public ResponseResult<UserVO> login(@RequestBody @Valid UserEntriesDTO userEntriesDTO){
        User user = userService.userLogin(userEntriesDTO);
        UserVO userVO = UserVO.builder()
                .userId(user.getId())
                .userType(user.getUserType())
                .token(tokenUtils.generateContinuousToken(user.getUserName(),user.getUserPassword()))
                .build();
        return ResponseResult.success(userVO);

    }
    
    
    @PostMapping(Const.API_URL + "/register")
    public ResponseResult<User> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        User user = userService.userRegister(userRegisterDTO);
        return ResponseResult.success(user);
    }
}
