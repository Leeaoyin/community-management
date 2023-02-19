package org.management.core.application.common.param.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDTO implements Serializable {
    
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotBlank(message = "疫苗名称不能为空")
    private String vaccinename;
    @NotNull(message = "预约时间")
    private Date ordertime;
}
