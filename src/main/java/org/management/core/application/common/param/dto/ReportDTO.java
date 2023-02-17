package org.management.core.application.common.param.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO implements Serializable {
    
    @NotNull(message = "健康状态不能为空")
    private Integer healthstate;
}
