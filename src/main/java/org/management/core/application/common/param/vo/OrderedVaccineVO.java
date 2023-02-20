package org.management.core.application.common.param.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderedVaccineVO implements Serializable {
    
    private Date ordertime;
    private String phone;
    private Integer state;
    private String vaccinename;
}
