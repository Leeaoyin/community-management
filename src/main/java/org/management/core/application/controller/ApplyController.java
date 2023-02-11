package org.management.core.application.controller;


import org.management.core.application.common.annotation.CurrentUser;
import org.management.core.application.common.param.dto.ActiveDTO;
import org.management.core.application.common.param.result.ResponseResult;
import org.management.core.application.common.param.vo.ActiveVO;
import org.management.core.domain.event.Const;
import org.management.core.infrastructure.repository.po.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ApplyController extends BaseController{
    
    
    
    
    @PostMapping(value = Const.API_URL+"applyActive")
    public ResponseResult<ActiveVO> applyActive(@CurrentUser User user, @RequestBody @Valid List<ActiveDTO> activeDTOList){
        
        
        return null;
    }
    
    
}
