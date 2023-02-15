package org.management.core.application.common.param.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class VerifyDTO implements Serializable {
    @NotNull(message = "id not allow to be null")
    private Integer id;
}
