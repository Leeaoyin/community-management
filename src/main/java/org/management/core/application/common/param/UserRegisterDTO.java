package org.management.core.application.common.param;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
public class UserRegisterDTO implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "用户类型不能为空")
    private Integer usertype;
    
    
}
