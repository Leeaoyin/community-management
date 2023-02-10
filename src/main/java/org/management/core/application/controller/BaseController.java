package org.management.core.application.controller;

import org.management.core.infrastructure.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


public class BaseController {
    
    @Autowired
    TokenUtils tokenUtils;
}
