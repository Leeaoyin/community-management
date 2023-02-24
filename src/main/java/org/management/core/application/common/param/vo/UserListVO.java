package org.management.core.application.common.param.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListVO implements Serializable {
    
    private String username;
    private String email;
    private String phone;
    private Integer roomnumber;
    private Integer healthstate;
    
}
