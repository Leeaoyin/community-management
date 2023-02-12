package org.management.core.application.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.management.core.domain.event.Const;
import org.management.core.domain.service.UserService;
import org.management.core.infrastructure.repository.po.User;
import org.management.core.infrastructure.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    
    @Autowired 
    TokenUtils tokenUtils;
    
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        String token = request.getHeader(Const.TOKEN_HEADER_STRING);
        if (Objects.isNull(token)) {
            log.error("{},request token error", request.getServletPath());
            return false;
        }
        String username  = tokenUtils.getUsername(token);
        User user = userService.getByUserName(username);
        request.setAttribute(Const.CURRENT_USER,user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
