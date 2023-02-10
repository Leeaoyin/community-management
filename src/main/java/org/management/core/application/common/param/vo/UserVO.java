package org.management.core.application.common.param.vo;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO implements Serializable {
    
    private Integer userId;
    private Integer userType;
    private String token;
}
