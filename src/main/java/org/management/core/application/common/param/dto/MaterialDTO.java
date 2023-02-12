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
public class MaterialDTO implements Serializable {
    
    @NotBlank(message = "物资不能为空")
    private String materialname;
    @NotNull(message = "数量不能为空")
    private Integer num;
    
    
    
}
