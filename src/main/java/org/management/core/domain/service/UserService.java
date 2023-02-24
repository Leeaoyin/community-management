package org.management.core.domain.service;

import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserInfoDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.application.common.param.vo.UserListVO;
import org.management.core.infrastructure.repository.po.User;

import java.util.List;

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
    Boolean userRegister(UserRegisterDTO userRegisterDTO);

    /**
     * add user information
     * @param user
     * @param userInfoDTO
     * @return
     */
    Boolean addUserInfo(User user, UserInfoDTO userInfoDTO);

    /**
     * get user information
     * @param user
     * @return
     */
    List<UserListVO> getUserList(User user);
}
