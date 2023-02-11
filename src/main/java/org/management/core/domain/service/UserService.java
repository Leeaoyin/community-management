package org.management.core.domain.service;

import org.management.core.application.common.param.dto.UserEntriesDTO;
import org.management.core.application.common.param.dto.UserRegisterDTO;
import org.management.core.infrastructure.repository.po.User;

public interface UserService {


    /**
     * login
     * @param userEntriesDTO
     * @return
     */
    User userLogin(UserEntriesDTO userEntriesDTO);

    /**
     * get user by name
     * @param username
     * @return
     */
    User getByUserName(String username);

    /**
     * register user
     * @param userRegisterDTO
     * @return
     */
    User userRegister(UserRegisterDTO userRegisterDTO);
}
