package org.management.core.application.controller;

import org.management.core.domain.event.Const;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


public class BaseController {
    
    @Autowired
    TokenUtils tokenUtils;
    
    protected Boolean exitAdministrator(User user){
        return Objects.equals(user.getId(), Const.ADMIN_TYPE);
    }
}
