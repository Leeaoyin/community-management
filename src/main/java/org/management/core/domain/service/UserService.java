package org.management.core.domain.service;

import org.management.core.application.common.param.UserEntriesDTO;
import org.management.core.infrastructure.repository.po.User;

public interface UserService {


    User userLogin(UserEntriesDTO userEntriesDTO);
}
