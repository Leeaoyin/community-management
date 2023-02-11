package org.management.core.application.common.param.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActiveDTO implements Serializable {
    
//    @NotNull(message = "用户id不能为空")
//    private Integer userid;
    @NotNull(message = "活动类型不能为空")
    private Integer activetype;
    @NotNull(message = "活动时间不能为空")
    private Date activetime;
    @NotBlank(message = "原因不能为空")
    private String reason;
    private List<String> familyfriend;
    
}
