package org.management.core.domain.service;

import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserInfoDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.infrastructure.repository.po.User;

public interface UserService {


    /**
     * login
     */
    User userLogin(UserEntriesDTO userEntriesDTO);

    /**
     * get user by name
     */
    User getByUserName(String username);

    /**
     * register user
     */
    User userRegister(UserRegisterDTO userRegisterDTO);
    
    Boolean addUserInfo(User user, UserInfoDTO userInfoDTO);
}
