package org.management.core.application.common.param.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO implements Serializable {
    
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "电话不能为空")
    private String phone;
    @NotNull(message = "房间号不能为空")
    private Integer roomnumber;
    @NotNull(message = "健康状态不能为空")
    private Integer healthstate;
    
}
